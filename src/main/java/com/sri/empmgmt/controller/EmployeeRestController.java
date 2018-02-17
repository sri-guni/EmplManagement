package com.sri.empmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sri.empmgmt.model.Employee;
import com.sri.empmgmt.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeRepository empRepository;
		
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public List<Employee> viewEmployees() {
		return empRepository.getAllEmployees();
	}
}
