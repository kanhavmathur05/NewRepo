package com.hibernatemapping.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernatemapping.model.UserDetails;
import com.hibernatemapping.model.UserHistory;
import com.hibernatemapping.services.UserHistoryService;
import com.hibernatemapping.services.UserServices;

@RestController
public class UserHistoryController {

	@Autowired
	UserServices userService;
	
	@Autowired
	UserHistoryService userHistoryService;
	
	Logger logger = LoggerFactory.getLogger(UserHistoryController.class);
	
	@RequestMapping(path="/saveUserHistory",method = RequestMethod.POST)
	public String addUserHistory(@RequestBody UserHistory userHistory) {
		UserDetails user=userService.getUserDetails(userHistory.getUserDetails().getUserID());
	//	userHistory.setUserDetails(userService.getUserDetails(userID));
//		userHistory.setUserDetails(userService.getUserDetails(77));
		userHistory.setUserDetails(user);
		return userHistoryService.addUserHistory(userHistory);
	}
	
	@RequestMapping(path="/deleteUserHistory/{userHistoryID}",method = RequestMethod.DELETE)
	public String deleteUserHistory(@PathVariable int userHistoryID)
	{
		return userHistoryService.deleteUserHistory(userHistoryID);
	}
	
	@RequestMapping(path="/showUserHistory/{userID}",method = RequestMethod.GET)
	public List<UserHistory> showUserHistory(@PathVariable int userID)
	{
		return userHistoryService.getUserHistory(userService.getUserDetails(userID));
	}
	
	@RequestMapping(path="/getAllUsersHistory",method = RequestMethod.GET)
	public List<UserHistory> getAllUsersHistory()
	{
		return userHistoryService.allUserHistory();
	}
	
	@RequestMapping(path="/updateUserHistory/{userID}",method = RequestMethod.POST)
	public String updateUserHistory(@RequestBody UserHistory userHistory,@PathVariable int userID) 
	{	
		UserDetails user=userService.getUserDetails(userID);
		userHistory.setUserDetails(user);
		return userHistoryService.addUserHistory(userHistory);
	}
}