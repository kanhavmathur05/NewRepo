package com.springandmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springandmongo.model.UserInfo;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, String>{

}
