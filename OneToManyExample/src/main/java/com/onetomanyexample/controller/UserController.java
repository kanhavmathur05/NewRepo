package com.onetomanyexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onetomanyexample.model.User;
import com.onetomanyexample.service.UserRepositoryService;

@RestController
public class UserController {

	@Autowired
	UserRepositoryService userRepositoryService;
	
	@RequestMapping(path="/saveUser",method = RequestMethod.POST)
	public String saveUser(@RequestBody User user)
	{
		return userRepositoryService.saveUser(user);
	}
	
	@RequestMapping(path="/deleteUser/{userID}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int userID)
	{
		return userRepositoryService.deleteUser(userID);
	}
	
	@RequestMapping(path="/getUser/{userID}",method = RequestMethod.GET)
	public User getUser(@PathVariable int userID)
	{
		return userRepositoryService.getUser(userID);
	}
	
}
