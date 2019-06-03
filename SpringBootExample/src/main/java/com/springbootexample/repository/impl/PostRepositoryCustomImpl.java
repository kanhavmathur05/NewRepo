package com.springbootexample.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.springbootexample.model.Posts;
import com.springbootexample.model.UserInfo;
import com.springbootexample.repository.PostRepositoryCustom;

public class PostRepositoryCustomImpl implements PostRepositoryCustom{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Posts> getPostsByUser(int userID) {
		

		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Posts> cq=cb.createQuery(Posts.class);
		
		Root<Posts> posts=cq.from(Posts.class);
		
		List<Predicate> predicates=new ArrayList<>();
		
		predicates.add(cb.equal(posts.get("userInfo"), userID));
		
		cq.where(predicates.toArray(new Predicate[0]));
		
		return em.createQuery(cq).getResultList();
		
		
	}

}
