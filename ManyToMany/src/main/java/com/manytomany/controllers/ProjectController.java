package com.manytomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.model.Project;
import com.manytomany.services.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(path = "/createProject",method = RequestMethod.POST)
	public String createProject(@RequestBody Project project)
	{
		return projectService.createProject(project);
	}
	
	@RequestMapping(path = "/deleteProject/{project_id}",method = RequestMethod.DELETE)
	public String deleteProject(@PathVariable int project_id)
	{
		return projectService.deleteProject(project_id);
	}
	
	@RequestMapping(path = "/getProjectDetails/{project_id}",method = RequestMethod.GET)
	public Project getProjectDetails(@PathVariable int project_id)
	{
		return projectService.getProjectDetails(project_id);
	}
}
