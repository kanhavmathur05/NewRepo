package com.manytomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.model.Project;
import com.manytomany.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public String createProject(Project project){
		try {
			projectRepository.save(project);
			return "Created";
		}
		catch(Exception ex)
		{
		System.out.println(ex);	
		return "Not Created";
		}
	}
	
	public Project getProjectDetails(int project_id){
		try {
			return projectRepository.findById(project_id).get();
		}
		catch(Exception ex)
		{
		System.out.println(ex);	
		return null;
		}
	}	
	public String deleteProject(int project_id){
		try {
			projectRepository.deleteById(project_id);
			return "Deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not Deleted";
		}
	}
	
}
