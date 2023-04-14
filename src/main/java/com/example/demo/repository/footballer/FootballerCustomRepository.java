package com.example.demo.repository.footballer;

import java.util.List;

import com.example.demo.models.Footballer;

public interface FootballerCustomRepository {
    List<Footballer> findByOptions(String firstOption, String secondOption);
}
