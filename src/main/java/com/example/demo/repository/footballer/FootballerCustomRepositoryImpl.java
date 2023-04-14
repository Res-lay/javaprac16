package com.example.demo.repository.footballer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Footballer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FootballerCustomRepositoryImpl implements FootballerCustomRepository{

    @Autowired
    private EntityManager entityManager;

	@Override
	public List<Footballer> findByOptions(String firstname, String lastname) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Footballer.class);
		Root<Footballer> footballer = cq.from(Footballer.class);

        Predicate firstNamePredicate = cb.equal(footballer.get("firstname"), firstname);
        Predicate lastNamePredicate = cb.equal(footballer.get("lastname"), lastname);

        cq.where(firstNamePredicate, lastNamePredicate);

        TypedQuery<Footballer> query = entityManager.createQuery(cq);

        return query.getResultList();
	}
    
    
}
