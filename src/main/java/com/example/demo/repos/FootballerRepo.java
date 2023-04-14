package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Footballer;

public interface FootballerRepo extends CrudRepository<Footballer, Long> {
    
}
