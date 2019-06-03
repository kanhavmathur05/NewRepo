package com.onetomanyexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomanyexample.model.User;
import com.onetomanyexample.repository.UserRepository;

@Service
public class UserRepositoryService {

	@Autowired
	UserRepository userRepository;
	
	public String saveUser(User user)
	{
		try
		{
			userRepository.save(user);
			return "User added";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to add";
		}
	}
	
	public String deleteUser(int userID)
	{
		try
		{
			userRepository.deleteById(userID);
			return "Deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not Deleted";
		}
	}
	public User getUser(int userID)
	{
		try
		{
			return userRepository.findById(userID).get();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
}