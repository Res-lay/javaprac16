package com.example.demo.repository.team;

import java.util.List;

import com.example.demo.models.Team;

public interface TeamCustomRepository {
    List<Team> findByOptions(String fitstOption, String secondOption);
    List<String> getData(Long Id);
}
