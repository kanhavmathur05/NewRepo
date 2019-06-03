package com.onetomanyexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomanyexample.model.Account;
import com.onetomanyexample.model.User;
import com.onetomanyexample.repository.AccountRepository;

@Service
public class AccountRepositoryService {

	@Autowired
	AccountRepository accountRepository;
	
	public String saveAccount(Account account)
	{
		try
		{
			accountRepository.save(account);
			return "Account added";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to add";
		}
	}
	
	public String deleteAccount(int accountID)
	{
		try
		{
			accountRepository.deleteById(accountID);
			return "Deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not Deleted";
		}
	}
	public List<Account> getAccounts(User user)
	{
		try
		{
		return accountRepository.getAccountsByUser(user);
		//	return (List<Account>) accountRepository.findAll();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
}
