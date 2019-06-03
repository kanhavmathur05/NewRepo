package com.onetomanyexample.repository;

import java.util.List;

import com.onetomanyexample.model.Account;
import com.onetomanyexample.model.User;

public interface AccountRepositoryCustom {
	List<Account> getAccountsByUser(User user);
}
