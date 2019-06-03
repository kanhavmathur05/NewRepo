package com.springandmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springandmongo.model.UserInfo;
import com.springandmongo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(path="/addUser",method = RequestMethod.POST)
	public String addUser(@RequestBody UserInfo userInfo)
	{
		return userService.addUser(userInfo);
	}
	
	@RequestMapping(path="/getUser/{userID}",method = RequestMethod.GET)
	public UserInfo getUser(@PathVariable String userID) 
	{
		return userService.getUser(userID);
	}
	
	@RequestMapping(path = "/getAllUsers",method = RequestMethod.GET)
	public List<UserInfo> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@RequestMapping(path = "/deleteUser/{userID}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String userID)
	{
		return userService.deleteUser(userID);
	}
	
}
