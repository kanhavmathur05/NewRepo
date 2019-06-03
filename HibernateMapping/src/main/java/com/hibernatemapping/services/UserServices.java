package com.hibernatemapping.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernatemapping.model.UserDetails;
import com.hibernatemapping.repository.UserRepository;

@Service
public class UserServices {

	Logger logger=LoggerFactory.getLogger(UserServices.class);
	
	@Autowired
	UserRepository userRepository;
	
	public String saveOrUpdateUser(UserDetails userDetails)
	{
		try
		{
			logger.info("UserID Value ::::::::::"+userDetails.getUserID());
			userRepository.save(userDetails);
			return "User Details Saved";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to save User Details";
		}
	}
	
	public String deleteUser(int userID)
	{
		try {
			userRepository.deleteById(userID);
			return "User Deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to delete";
		}
	}
	
	public UserDetails getUserDetails(int userID)
	{
		try {
			return userRepository.findById(userID).get();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	public List<UserDetails> getAllUsers()
	{
		try
		{
			return (List<UserDetails>)userRepository.findAll();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
}
