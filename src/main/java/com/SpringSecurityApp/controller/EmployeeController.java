package com.SpringSecurityApp.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurityApp.model.Employee;
import com.SpringSecurityApp.service.EmployeeService;

@RestController
public class EmployeeController {
	
private EmployeeService employeeService; 
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(path="/emps",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Employee> getAllEmployees() {
        return new ArrayList<Employee>();
		//return employeeService.getAllEmployees();
    }


    @RequestMapping(path="/getEmp/{email}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Employee getEmployee(@PathVariable("email") String email) throws IOException {

        return employeeService.findEmployeeByEmail(email);

    }
}
