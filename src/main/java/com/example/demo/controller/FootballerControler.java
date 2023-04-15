package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Footballer;
import com.example.demo.repository.footballer.FootballerRepo;

@RestController
@RequestMapping
public class FootballerControler {
    @Autowired
    private FootballerRepo footballerRepos;

    @GetMapping("/footballer")
    public Iterable<Footballer> getFootballers(){
        // log.info("Find all footballers");
        return footballerRepos.findAll();
    }

    @GetMapping("/footballer/{firstname}/{lastname}")
    public List<Footballer> filterBy(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname){
        // log.info("Get certain footballer");
        return footballerRepos.findByOptions(firstname, lastname);
    }
}
