package com.manytomany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.model.Employee;
import com.manytomany.model.Project;
import com.manytomany.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public String saveEmployee(Employee employee){
		try {
			employeeRepository.save(employee);
			return "Created";
		}
		catch(Exception ex)
		{
		System.out.println(ex);	
		return "Not Created";
		}
	}
	
	public Employee getEmployeeDetails(int employee_id){
		try {
			return employeeRepository.findById(employee_id).get();
		}
		catch(Exception ex)
		{
		System.out.println(ex);	
		return null;
		}
	}	
	public String deleteEmployee(int employee_id){
		try {
			employeeRepository.deleteById(employee_id);
			return "Deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "Not Deleted";
		}
	}
	
}
