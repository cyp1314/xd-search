package com.xdclass.search.controller;

import com.xdclass.search.model.NBAPlayer;
import com.xdclass.search.service.NBAPlayerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/nba")
public class NBASearchController {

    @Autowired
    private NBAPlayerService playerService;

    @RequestMapping("/importAll")
    public String importAll() {
        try {
            playerService.importAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/searchPlayerByName")
    public List<NBAPlayer> searchPlayerByName(
            @RequestParam(name = "displayNameEn", required = false) String displayNameEn
    ) {
        List<NBAPlayer> players = null;
        try {
            players = playerService.searchPlayerByName("displayNameEn", displayNameEn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }


    @RequestMapping("/searchTerm")
    public List<NBAPlayer> searchTerm(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "teamName", required = false) String teamName) {
        List<NBAPlayer> players = null;
        try {
            if (StringUtils.isNotBlank(country)) {
                players = playerService.searchTerm("country", country);
            } else if (StringUtils.isNotBlank(teamName)) {
                players = playerService.searchTerm("teamName", teamName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }


    @RequestMapping("/searchMatchPrefix")
    public List<NBAPlayer> searchMatchPrefix(
            @RequestParam(name = "displayNameEn", required = false) String displayNameEn) {
        List<NBAPlayer> players = null;
        try {
            players = playerService.searchMatchPrefix("displayNameEn", displayNameEn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
