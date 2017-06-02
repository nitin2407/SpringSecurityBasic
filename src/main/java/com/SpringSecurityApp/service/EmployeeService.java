package com.SpringSecurityApp.service;

import org.springframework.stereotype.Service;

import com.SpringSecurityApp.model.Employee;
import com.SpringSecurityApp.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	private IEmployeeRepository employeeRepository;
	
	public EmployeeService(IEmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	public Employee findEmployeeByEmail(String email){
		return employeeRepository.findByEmail(email);
	}
	
	public String findUserRoleByEmail(String email){
		return employeeRepository.findUserRole(email);
	}
	
}
