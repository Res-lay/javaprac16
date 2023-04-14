package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Team;
import com.example.demo.repos.TeamRepos;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepos teamRepos;

    @GetMapping
    public Iterable<Team> getTeams(){
        return teamRepos.findAll();
    }
}
