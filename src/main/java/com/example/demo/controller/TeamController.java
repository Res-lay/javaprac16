package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Team;
import com.example.demo.repository.team.TeamRepos;
import com.example.demo.service.EmailService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/team")
@Transactional
public class TeamController {

    @Autowired
    private TeamRepos teamRepos;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public Iterable<Team> getTeams(){
        // log.info("get all teams");
        return teamRepos.findAll();
    }
    @PostMapping
    public void createTeam(@RequestBody Map<String, String> message){
        Team team = new Team(message.get("name"), message.get("creationDate"));
        emailService.sendEmail(message.get("name"));
        teamRepos.save(team);
    }
    @GetMapping("/team/{name}/{creationDate}")
    public List<Team> filterBy(@PathVariable("name") String name, @PathVariable("creationDate") String creationDate){
        // log.info("Get certain team {} {}", name, creationDate);
        return teamRepos.findByOptions(name, creationDate);
    }
}
