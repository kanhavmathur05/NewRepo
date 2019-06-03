package com.springbootexample.repository;

import java.util.List;

import com.springbootexample.model.Posts;
import com.springbootexample.model.UserInfo;

public interface PostRepositoryCustom {
	public List<Posts> getPostsByUser(int userInfo);
}
