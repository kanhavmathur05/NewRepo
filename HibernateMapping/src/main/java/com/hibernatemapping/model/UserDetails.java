package com.hibernatemapping.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="userdetails")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "userID")
public class UserDetails implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	
	private String userName;
//	,mappedBy="userDetails"
	@OneToOne(fetch = FetchType.LAZY,cascade ={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE} ,mappedBy="userDetails",optional = false)
	//@JoinColumn(name="userHistoryID")
//	@JsonIgnore
//	@JsonManagedReference
	private UserHistory userHistory;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserHistory getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(UserHistory userHistory) {
		this.userHistory = userHistory;
	}	

	
}