package com.springbootexample.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootexample.model.Posts;
import com.springbootexample.model.UserInfo;
import com.springbootexample.repository.PostRepository;
import com.springbootexample.services.PostRepositoryService;
import com.springbootexample.services.UserRepositoryService;

@RestController
public class PostsController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	PostRepositoryService postRepositoryService;
	
	@Autowired
	UserRepositoryService userRepositoryService;
	
	@RequestMapping(path="/addPost",method=RequestMethod.POST)
	public String addPost(@RequestBody Posts post)
	{
		postRepositoryService.addPost(post);
		return "Blog Post Added!";
	}
	
	@RequestMapping(path="/getAllPosts/{userID}",method=RequestMethod.GET)
	public List<Posts> getPostsByUser(@PathVariable int userID)
	{
		logger.info("USER ID::"+userID);
		return postRepositoryService.getPostByUser(userID);
		
	}
	
	@RequestMapping(path="/getPost/{postID}",method = RequestMethod.GET)
	public Posts getPost(@PathVariable int postID)
	{
		return postRepositoryService.getPost(postID);
	}
	
	@RequestMapping(path="/deletePost/{postID}",method = RequestMethod.DELETE)
	public String deletePost(@PathVariable int postID)
	{
		return postRepositoryService.deletePost(postID);
		
	}
	@RequestMapping(path="/updatePost",method=RequestMethod.POST)
	public String updatePost(@RequestBody Posts post)
	{
		logger.info("POSTS DETAILS::"+post.getUserInfo().getUserID());
		postRepositoryService.updatePost(post);
		return "Blog Post Updated!";
	}
}
