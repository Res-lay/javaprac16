package com.example.demo.repository.footballer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Footballer;

public interface FootballerRepo extends JpaRepository<Footballer, Long>, FootballerCustomRepository {
    
}
