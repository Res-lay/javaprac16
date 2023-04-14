package com.example.demo.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "team")
public class Team {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String creationDate;

    @SequenceGenerator(name = "team_seq", sequenceName =
            "team_sequence", allocationSize = 1)
    @GeneratedValue(generator = "team_seq", strategy =
            GenerationType.SEQUENCE)
    
    @OneToMany(mappedBy = "team")
    public List<Footballer> footballers;

    public Team(String name, String creationDate){
        this.creationDate = creationDate;
        this.name = name;
    }

    Team(){}
}
