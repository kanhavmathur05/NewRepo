package com.springbootexample.repository;

import java.util.List;import java.util.Optional;
import org.springframework.data.repository.Repository;
import com.springbootexample.model.UserInfo;

public interface UserRepositoryCustom{
	public List<UserInfo> getUserByNameAndContact(String userName,int contactNo);
}
