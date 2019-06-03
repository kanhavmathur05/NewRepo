package com.onetomanyexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.onetomanyexample.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
