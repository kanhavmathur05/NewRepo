package com.springbootexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexample.model.Posts;
import com.springbootexample.model.UserInfo;
import com.springbootexample.repository.PostRepository;

@Service
public class PostRepositoryService {

	@Autowired
	PostRepository postRepository;
	
	public void addPost(Posts post)
	{
		try {
			postRepository.save(post);			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public List<Posts> getPostByUser(int userID)
	{
		try {
		 return postRepository.getPostsByUser(userID);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	public Posts getPost(int postID)
	{
		try
		{
			return postRepository.findById(postID).get();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	
	public String deletePost(int postID)
	{
		try
		{
			postRepository.deleteById(postID);
			return "Post deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not deleted";
		}
	}
	
	public String updatePost(Posts post)
	{
		try
		{
			postRepository.save(post);
			return "Post Updated";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not Udated";
		}
	}
	
}
