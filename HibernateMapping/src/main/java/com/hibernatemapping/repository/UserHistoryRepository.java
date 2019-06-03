package com.hibernatemapping.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hibernatemapping.model.UserHistory;

public interface UserHistoryRepository extends CrudRepository<UserHistory, Integer>,UserHistoryRepositoryCustom{
	
	//@Query("select u from UserHistory u where u.userID=?1")
	//public UserHistory getUserHistory(int userID);
	
}
