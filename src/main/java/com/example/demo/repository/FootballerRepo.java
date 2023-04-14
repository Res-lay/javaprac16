package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Footballer;

public interface FootballerRepo extends CrudRepository<Footballer, Long>, FootballerCustomRepository {
    
}
