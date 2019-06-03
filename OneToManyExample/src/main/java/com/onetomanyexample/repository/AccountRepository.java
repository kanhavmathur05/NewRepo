package com.onetomanyexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.onetomanyexample.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>,AccountRepositoryCustom{

}
