package com.springandmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springandmongo.model.UserInfo;
import com.springandmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public String addUser(UserInfo userInfo)
	{
		try
		{
			userRepository.save(userInfo);
			return "Inserted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to insert";
		}
	}
	
	public UserInfo getUser(String userID)
	{
		try
		{
			return userRepository.findById(userID).get();
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	public List<UserInfo> getAllUsers()
	{
		try
		{
			return userRepository.findAll();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	public String deleteUser(String userID)
	{
		try {
			userRepository.deleteById(userID);
			return "Deleted";
		}
		catch(Exception ex)
		{
			return "Not Deleted";
		}
	}
	
}
