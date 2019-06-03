package com.springbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import com.springbootexample.model.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, Integer>,UserRepositoryCustom{

}
