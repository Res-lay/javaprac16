package com.example.demo.repository.footballer;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Footballer;

public interface FootballerRepo extends CrudRepository<Footballer, Long>, FootballerCustomRepository {
    
}
