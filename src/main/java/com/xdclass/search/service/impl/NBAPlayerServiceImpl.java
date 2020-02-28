package com.xdclass.search.service.impl;

import com.xdclass.search.dao.NBAPlayerDao;
import com.xdclass.search.model.NBAPlayer;
import com.xdclass.search.service.NBAPlayerService;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class NBAPlayerServiceImpl implements NBAPlayerService {

    public static final String NBA_INDEX = "nba";
    @Resource
    private RestHighLevelClient client;

    @Autowired
    private NBAPlayerDao nbaPlayerDao;

    @Override
    public boolean addPlayer(NBAPlayer player, String id) throws IOException {
        IndexRequest request = new IndexRequest("nba")
                .id(id)
                .source(beanToMap(player));
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        return true;
    }

    @Override
    public Map<String, Object> getPlayer(String id) throws IOException {
        GetRequest request = new GetRequest("nba")
                .id(id);

        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        return response.getSource();
    }

    @Override
    public boolean updatePlayer(NBAPlayer player, String id) throws IOException {
        UpdateRequest request = new UpdateRequest("nba", id)
                .doc(beanToMap(player));
        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);
        return true;
    }


    @Override
    public boolean deletePlayer(String id) throws IOException {
        DeleteRequest request = new DeleteRequest("nba", id);
        DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
        return true;
    }

    @Override
    public boolean deleteAllPlayer() throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest(NBA_INDEX);
        request.setQuery(QueryBuilders.matchAllQuery());
        request.setTimeout(new TimeValue(2, TimeUnit.SECONDS));
        BulkByScrollResponse response = client.deleteByQuery(request, RequestOptions.DEFAULT);

        return true;
    }


    @Override
    public boolean importAll() throws IOException {
        List<NBAPlayer> players = nbaPlayerDao.selectAll();
        for (NBAPlayer player : players) {
            this.addPlayer(player, String.valueOf(player.getId()));
        }
        return false;
    }

    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) != null) {
                    map.put(key + "", beanMap.get(key));
                }
            }
        }
        return map;
    }
}
