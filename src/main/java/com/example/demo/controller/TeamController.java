package com.example.demo.controller;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Team;
import com.example.demo.repos.TeamRepos;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepos teamRepos;

    @GetMapping
    public Iterable<Team> getTeams(){
        return teamRepos.findAll();
    }
    SessionFactory sessionFactory;
    Session session = sessionFactory.openSession();

    @GetMapping("/sorted/{name}")
    public List<Team> sortedByName(@PathVariable("name") String name){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Team> criteriaQuery = criteriaBuilder.createQuery(Team.class);
        Root<Team> root = criteriaQuery.from(Team.class);
        criteriaQuery.select(root);
        Query<Team> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
