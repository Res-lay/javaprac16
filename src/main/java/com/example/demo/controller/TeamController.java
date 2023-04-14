package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Team;
import com.example.demo.repos.TeamRepos;
import com.example.demo.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepos teamRepos;
    private TeamService teamService;

    @GetMapping
    public Iterable<Team> getTeams(){
        return teamRepos.findAll();
    }
    @GetMapping("/sorted/{name}")
    public List<Team> sortedByName(@PathVariable("name") String name){
        return teamService.filterBy(name);
    }
}
