package com.onetomanyexample.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.onetomanyexample.model.Account;
import com.onetomanyexample.model.User;

public class AccountRepositoryCustom implements com.onetomanyexample.repository.AccountRepositoryCustom{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Account> getAccountsByUser(User user) {
	
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Account> cq=cb.createQuery(Account.class);
		
		Root<Account> account=cq.from(Account.class);
		
		List<Predicate> predicates=new ArrayList<>();
		
		predicates.add(cb.equal(account.get("user"), user));
		
		cq.where(predicates.toArray(new Predicate[0]));
		
		return em.createQuery(cq).getResultList();
	
	}

}
