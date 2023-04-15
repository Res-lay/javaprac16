package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Team;
import com.example.demo.repository.team.TeamRepos;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class TeamController {

    @Autowired
    private TeamRepos teamRepos;

    @GetMapping("/team")
    public Iterable<Team> getTeams(){
        log.info("get all teams");
        return teamRepos.findAll();
    }
    @GetMapping("/team/{name}/{creationDate}")
    public List<Team> filterBy(@PathVariable("name") String name, @PathVariable("creationDate") String creationDate){
        log.info("Get certain team {} {}", name, creationDate);
        return teamRepos.findByOptions(name, creationDate);
    }
}
