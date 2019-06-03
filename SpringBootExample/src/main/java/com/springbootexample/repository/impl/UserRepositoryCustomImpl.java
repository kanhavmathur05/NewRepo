package com.springbootexample.repository.impl;

import java.util.ArrayList;import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootexample.model.UserInfo;
import com.springbootexample.repository.UserRepositoryCustom;

@Repository
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<UserInfo> getUserByNameAndContact(String userName, int contactNo) {
		
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<UserInfo> cq=cb.createQuery(UserInfo.class);
		
		Root<UserInfo> user=cq.from(UserInfo.class);
		
		List<Predicate> predicates=new ArrayList<>();
		
		predicates.add(cb.equal(user.get("userName"), userName));
		predicates.add(cb.equal(user.get("contactNo"), contactNo));
		
		cq.where(predicates.toArray(new Predicate[0]));
		
		return em.createQuery(cq).getResultList();
		
	}

}
