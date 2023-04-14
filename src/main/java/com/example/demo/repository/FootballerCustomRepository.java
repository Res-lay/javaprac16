package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Footballer;

public interface FootballerCustomRepository {
    List<Footballer> findByOptions(String firstname, String lastname);
}
