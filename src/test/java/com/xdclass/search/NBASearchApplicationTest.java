package com.xdclass.search;

import com.alibaba.fastjson.JSONObject;
import com.xdclass.search.dao.NBAPlayerDao;
import com.xdclass.search.model.NBAPlayer;
import com.xdclass.search.service.NBAPlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NBASearchApplicationTest {

    @Resource
    private NBAPlayerDao nbaPlayerDao;

    @Autowired
    private NBAPlayerService playerService;

    @Test
    public void selectAll(){
        System.out.println(JSONObject.toJSON(nbaPlayerDao.selectAll()));
    }


    @Test
    public void addPlay() throws IOException {
        NBAPlayer player = new NBAPlayer();
        player.setId(999);
        player.setDisplayName("库里");

        playerService.addPlayer(player, "999");
    }

    @Test
    public void getPlayer() throws IOException {
        Map<String, Object> player = playerService.getPlayer("999");

        System.out.println(JSONObject.toJSON(player));
    }


    @Test
    public void updatePlayer() throws IOException {
        NBAPlayer player = new NBAPlayer();
        player.setId(999);
        player.setDisplayName("史蒂芬库里");
        player.setDisplayNameEn("Curry");

        playerService.updatePlayer(player, "999");
    }

    @Test
    public void deletePlayer() throws IOException {
        boolean b = playerService.deletePlayer("999");
        System.out.println(b);
    }

    @Test
    public void deleteAllPlayer() throws IOException {
        boolean b = playerService.deleteAllPlayer();
        System.out.println(b);
    }


    @Test
    public void searchPlayerByName() throws IOException {
        List<NBAPlayer> players = playerService.searchPlayerByName("displayNameEn", "james");

        for (NBAPlayer player : players) {
            System.out.println(player.toString());
        }
    }

    @Test
    public void searchTermByTeamName() throws IOException {
        List<NBAPlayer> players = playerService.searchTerm("teamName", "勇士");
//        List<NBAPlayer> players = playerService.searchTerm("country", "美国");

        System.out.println("Player Count : " + players.size() );
        for (NBAPlayer player : players) {
            System.out.println(player.toString());
        }
    }

    @Test
    public void searchTermByCountry() throws IOException {
        List<NBAPlayer> players = playerService.searchTerm("country", "法国");

        System.out.println("Player Count : " + players.size() );
        for (NBAPlayer player : players) {
            System.out.println(player.toString());
        }
    }


}
