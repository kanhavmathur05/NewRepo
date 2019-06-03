package com.manytomany.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.model.Employee;
import com.manytomany.model.Project;
import com.manytomany.services.EmployeeService;
import com.manytomany.services.ProjectService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectService projectService;
	
	@RequestMapping(path = "/saveEmployee",method = RequestMethod.POST)
	public String saveEmloyee(@RequestBody Employee employee)
	{
		List<Project> projectList=new ArrayList<>();
		projectList.add(projectService.getProjectDetails(12));
		employee.setProjects(projectList);
		return employeeService.saveEmployee(employee);
	}
	
	@RequestMapping(path = "/deleteEmployee/{employee_id}",method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable int employee_id)
	{
		return employeeService.deleteEmployee(employee_id);
	}
	
	@RequestMapping(path="/getEmployee/{employee_id}",method = RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable int employee_id)
	{
		return employeeService.getEmployeeDetails(employee_id);
	}
	
}
