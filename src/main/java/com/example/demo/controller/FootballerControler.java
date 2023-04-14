package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Footballer;
import com.example.demo.repos.FootballerRepo;

@RestController
@RequestMapping("/footballer")
public class FootballerControler {
    @Autowired
    private FootballerRepo footballerRepos;

    @GetMapping
    public Iterable<Footballer> getFootballers(){
        return footballerRepos.findAll();
    }
}
