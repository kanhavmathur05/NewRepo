package com.springbootexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.springbootexample.model.Posts;

public interface PostRepository extends CrudRepository<Posts, Integer>,PostRepositoryCustom{

}
