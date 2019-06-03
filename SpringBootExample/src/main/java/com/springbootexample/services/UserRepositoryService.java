package com.springbootexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexample.model.UserInfo;
import com.springbootexample.repository.UserRepository;

@Service
public class UserRepositoryService
{
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(UserInfo userInfo)
	{
		try{
				userRepository.save(userInfo);
		}
		catch(Exception ex)
		{
		System.out.println(ex);	
		}

	}
	
	public void deleteUserByID(int userID)
	{
		try {
			userRepository.deleteById(userID);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public UserInfo getUser(int userID)
	{
		UserInfo userInfo;
		try
		{
			userInfo=userRepository.findById(userID).get();
			return userInfo;
		}
		
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	public List<UserInfo> getAllUsers()
	{
		List<UserInfo> userList;
		try {
			userList= (List<UserInfo>) userRepository.findAll();
			return userList;
		}
		catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	public UserInfo getUserByNameAndContactDetails(String userName,int contactNo){
	{
		try
		{
			UserInfo userInfo=(UserInfo) userRepository.getUserByNameAndContact(userName, contactNo);
			return userInfo;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	}
	}
