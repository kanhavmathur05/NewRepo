package com.hibernatemapping.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.hibernatemapping.model.UserDetails;
import com.hibernatemapping.model.UserHistory;
import com.hibernatemapping.repository.UserHistoryRepositoryCustom;


public class UserHistoryRepositoryCustomImpl implements UserHistoryRepositoryCustom{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<UserHistory> getUserHistory(UserDetails userDetails) {
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<UserHistory> cq=cb.createQuery(UserHistory.class);
		
		Root<UserHistory> userHistory=cq.from(UserHistory.class);
		
		List<Predicate> predicates=new ArrayList<>();
		
		predicates.add(cb.equal(userHistory.get("userDetails"), userDetails));
		
		cq.where(predicates.toArray(new Predicate[0]));
		
		return em.createQuery(cq).getResultList();
	}

}
