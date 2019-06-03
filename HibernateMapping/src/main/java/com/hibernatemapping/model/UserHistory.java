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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="userhistory")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "userHistoryID")
public class UserHistory implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userHistoryID;
	
	private int workExperience;
	private String pastExperience;
//	,mappedBy = "userHistory"
	//@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="userID")
//	@JsonBackReference
	private UserDetails userDetails;

	public int getUserHistoryID() {
		return userHistoryID;
	}
 
	public void setUserHistoryID(int userHistoryID) {
		this.userHistoryID = userHistoryID;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}

	public String getPastExperience() {
		return pastExperience;
	}

	public void setPastExperience(String pastExperience) {
		this.pastExperience = pastExperience;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
