package com.example.demo.service;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.models.Team;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {
    SessionFactory sessionFactory;
    Session session = sessionFactory.openSession();
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Team> criteriaQuery = criteriaBuilder.createQuery(Team.class);

    Root<Team> root = criteriaQuery.from(Team.class);

    
    public List<Team> filterBy(String param){
        criteriaQuery.select(root);
        Query<Team> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
