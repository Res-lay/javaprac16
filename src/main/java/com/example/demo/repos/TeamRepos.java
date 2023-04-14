package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Team;



public interface TeamRepos extends CrudRepository<Team, Long>{
    
}
