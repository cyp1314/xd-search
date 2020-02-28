package com.xdclass.search.controller;

import com.xdclass.search.service.NBAPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/nba")
public class NBASearchController {

    @Autowired
    private NBAPlayerService playerService;

    @RequestMapping("/importAll")
    public String importAll(){
        try {
            playerService.importAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
