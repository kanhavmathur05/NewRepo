package com.manytomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.manytomany.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
