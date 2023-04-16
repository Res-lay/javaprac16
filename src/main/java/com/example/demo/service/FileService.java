package com.example.demo.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.models.Footballer;
import com.example.demo.models.Team;
import com.example.demo.repository.footballer.FootballerRepo;
import com.example.demo.repository.team.TeamRepos;

@Service
public class FileService {
    @Autowired
    private TeamRepos teamRepos;

    @Autowired
    private FootballerRepo footballerRepo;

    @Scheduled(fixedRate = 60000)
    public void CreateAndDelete(){
        File directory = new File("src/main/java/com/example/demo/models/data");
        if(directory.exists()){
            for(File file : directory.listFiles()){
                file.delete();
            }
        }else{
            directory.mkdir();
        }

        Iterable<Footballer> footballers = footballerRepo.findAll();
        Iterable<Team> teams = teamRepos.findAll();

        
        for(Footballer footballer: footballers){
            try{
                FileWriter fileFootballer = new FileWriter("src/main/java/com/example/demo/models/data/" + footballer.getFirstname() + ".txt");
                List<String> data = footballerRepo.getData(footballer.getId());
                for (String line: data){
                    fileFootballer.write(line + "\n");
                }
                fileFootballer.close();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        for(Team team: teams){
            try{
                FileWriter fileTeam = new FileWriter("src/main/java/com/example/demo/models/data/" + team.getName() + ".txt");
                List<String> data = teamRepos.getData(team.getId());
                for (String line: data){
                    fileTeam.write(line + "\n");
                }
                fileTeam.close();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
