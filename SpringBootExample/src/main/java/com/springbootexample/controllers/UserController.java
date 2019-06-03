package com.springbootexample.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootexample.model.UserInfo;
import com.springbootexample.repository.UserRepository;
import com.springbootexample.services.UserRepositoryService;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	
	@Autowired
	UserRepositoryService userRepositoryService;
	
	
	@GetMapping("/")
	public String rootMethod()
	{
		logger.debug("A DEBUG Message:");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		
	    return "Root Method";
	}
	
	
	@RequestMapping(path="/saveUserDetails",method=RequestMethod.POST)
	public String welcomeUser(@RequestBody UserInfo userInfo)
	{
		logger.info(""+userInfo.getUserName());	
		userRepositoryService.saveUser(userInfo);
			return "Data Saved!!";
	}
	
	@RequestMapping(path="/deleteUser/{userID}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable int userID)
	{
//		logger.debug("User Id is :::::"+userID);
		//addressRepository.deleteById(userRepository.findById(userID).get().getAddress().getAddressID());
		
		//userRepository.deleteById(userID);
		//userRepository.deleteUser(userID);
		userRepositoryService.deleteUserByID(userID);
		return "User Deleted";
	}
	
	
	@RequestMapping(path="/getAllUsers",method=RequestMethod.GET)
	public Iterable<UserInfo> getUsers()
	{	 
//		logger.debug("Get all users called!!");
		return userRepositoryService.getAllUsers();
	}
	
	@RequestMapping(path="/getUser/{userID}",method=RequestMethod.GET)
	public UserInfo getUserByID(@PathVariable int userID)
	{


			//logger.debug("User Id is :::::"+userID);
			//UserInfo user=userRepository.findById(userID).get();
			UserInfo userInfo=userRepositoryService.getUser(userID);
			return userInfo;
	}
	
	@RequestMapping(path="/updateUser/{userID}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable int userID, @RequestBody UserInfo userDetails)
	{
		userRepositoryService.getUser(userID);
		//userDetails.setAddress(userRepositoryService.getUser(userID).getAddress());
		userRepositoryService.saveUser(userDetails);	
		
		return "User Details Updated";
	}
	
	@RequestMapping(path="/getUserByUsernameAndContact/{userName}/{contactNo}",method=RequestMethod.GET)
	public UserInfo getUserByUserNameAndContactNo(@PathVariable String userName, @PathVariable int contactNo)
	{
		return userRepositoryService.getUserByNameAndContactDetails(userName, contactNo);
	}
}
