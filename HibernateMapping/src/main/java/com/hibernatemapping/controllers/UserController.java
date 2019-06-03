package com.hibernatemapping.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernatemapping.model.UserDetails;
import com.hibernatemapping.services.UserHistoryService;
import com.hibernatemapping.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	UserServices userService;
	
	@Autowired
	UserHistoryService userHistoryService;
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(path="/saveUser",method =RequestMethod.POST)
	public String saveOrUpdateUser(@RequestBody UserDetails userDetails)
	{
		logger.info("User Value::"+userDetails.getUserID());
		return userService.saveOrUpdateUser(userDetails);
	}
	
	@RequestMapping(path="/deleteUser/{userID}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int userID)
	{
		return userService.deleteUser(userID);
	}
	
	@RequestMapping(path="/getUser/{userID}",method = RequestMethod.GET)
	public UserDetails getUser(@PathVariable int userID)
	{
		return userService.getUserDetails(userID);
	}
	
	@RequestMapping(path="/getAllUsers",method = RequestMethod.GET)
	public List<UserDetails> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
}
