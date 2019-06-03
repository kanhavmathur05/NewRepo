package com.manytomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.manytomany.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
