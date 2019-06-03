package com.hibernatemapping.repository;

import org.springframework.data.repository.CrudRepository;

import com.hibernatemapping.model.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, Integer>{

}
