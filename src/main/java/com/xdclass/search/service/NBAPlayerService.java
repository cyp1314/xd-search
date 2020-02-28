package com.xdclass.search.service;

import com.xdclass.search.model.NBAPlayer;

import java.io.IOException;
import java.util.Map;

public interface NBAPlayerService {
    boolean addPlayer(NBAPlayer player, String id) throws IOException;

    Map<String, Object> getPlayer(String id) throws IOException;

    boolean updatePlayer(NBAPlayer player, String id) throws IOException;

    boolean deletePlayer(String id) throws IOException;

    boolean deleteAllPlayer() throws IOException;

    boolean importAll() throws IOException;

}
