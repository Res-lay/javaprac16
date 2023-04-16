package com.example.demo.repository.team;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TeamCustomRepositoryImpl implements TeamCustomRepository{

    @Autowired
    private EntityManager entityManager;

	@Override
	public List<Team> findByOptions(String name, String creationDate) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Team.class);
        
        Root<Team> team = cq.from(Team.class);

        Predicate namePredicate = cb.equal(team.get("name"), name);
        Predicate creationDatePredicate = cb.equal(team.get("creationDate"), creationDate);

        cq.where(namePredicate, creationDatePredicate);

        TypedQuery<Team> query = entityManager.createQuery(cq);

        return query.getResultList();
        
	}

    @Override
    public List<String> getData(Long Id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Team.class);
		Root<Team> team = cq.from(Team.class);

        Predicate IdPredicate = cb.equal(team.get("Id"), Id);
        cq.where(IdPredicate);
        TypedQuery<Team> query = entityManager.createQuery(cq);
        Team team2 = query.getSingleResult();
        List<String> data = new ArrayList<>();
        data.add("Name: " + team2.getName());
        data.add("CreationDate: " + team2.getCreationDate());
        return data;
    }

    
}
