package com.SpringSecurityApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurityApp.model.Employee;
import com.SpringSecurityApp.service.EmployeeService;

@RestController
public class AccountController {
	
	private EmployeeService employeeService; 
	
	@Autowired
	public AccountController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	
	}
	
	@RequestMapping(path = "/login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee Authenticate(@RequestBody Employee employee)
	{
		return employee;
		
	}
}
