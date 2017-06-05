package com.SpringSecurityApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	//@RequestBody 
	//method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE
	/*@RequestMapping(path = "/login",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee Authenticate(Employee employee)
	{
		System.out.println(employee.getEmail());
		return employee;
		
	}

	@RequestMapping(path = "/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee sendUser(@RequestBody Employee employee)
	{
		System.out.println(employee.getEmail());
		return employee;
		
	}*/
	@RequestMapping(path = "/login")
	public Employee Authenticate(Employee employee)
	{
		System.out.println(employee.getEmail());
		return employee;
		
	}
}

