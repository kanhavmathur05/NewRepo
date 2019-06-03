package com.onetomanyexample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onetomanyexample.model.Account;
import com.onetomanyexample.model.User;
import com.onetomanyexample.service.AccountRepositoryService;
import com.onetomanyexample.service.UserRepositoryService;

@RestController
public class AccountsController {
	@Autowired
	AccountRepositoryService accountRepositoryService;
	
	@Autowired
	UserRepositoryService userRepositoryService;
	
	Logger logger = LoggerFactory.getLogger(AccountsController.class);
	
	
	@RequestMapping(path="/saveAccount",method = RequestMethod.POST)
	public String saveAccount(@RequestBody Account account)
	{
	//	account.setUser(userRepositoryService.getUser(account.getUser().getUserID()));
		//account.setUser(userRepositoryService.getUser(5));
		System.out.println("THIS IS USER ID::"+account.getUser().getUserID());
		logger.info("USER ID in Account::"+account.getUser());
		return accountRepositoryService.saveAccount(account);
	}
	
	@RequestMapping(path="/deleteAccount/{accountID}",method = RequestMethod.DELETE)
	public String deleteAccount(@PathVariable int accountID)
	{
		return accountRepositoryService.deleteAccount(accountID);
	}
	
	@RequestMapping(path="/getAccounts/{userID}",method = RequestMethod.GET)
	public List<Account> getAccounts(@PathVariable int userID)
	{
		return accountRepositoryService.getAccounts(userRepositoryService.getUser(userID));
	}
}
