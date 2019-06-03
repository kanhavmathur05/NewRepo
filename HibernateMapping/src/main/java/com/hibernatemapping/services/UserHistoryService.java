package com.hibernatemapping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernatemapping.model.UserDetails;
import com.hibernatemapping.model.UserHistory;
import com.hibernatemapping.repository.UserHistoryRepository;

@Service
public class UserHistoryService {

	@Autowired
	UserHistoryRepository userHistoryRepository;
	
	public String addUserHistory(UserHistory userHistory)
	{
		try {
			userHistoryRepository.save(userHistory);
			return "Details saved";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to save details";
		}
	}
	
	public String deleteUserHistory(int userHistoryID)
	{
		try {
			userHistoryRepository.deleteById(userHistoryID);
			return "Details Deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Unable to delete details";
		}
	}
	
	public List<UserHistory> getUserHistory(UserDetails userID)
	{
		try {
			return userHistoryRepository.getUserHistory(userID);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	public List<UserHistory> allUserHistory()
	{
			try {
				return  (List<UserHistory>) userHistoryRepository.findAll();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				return null;
			}
		}
}
