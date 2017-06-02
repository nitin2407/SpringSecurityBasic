package com.SpringSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.SpringSecurityApp.model.CustomEmployeeDetails;
import com.SpringSecurityApp.model.Employee;
import com.SpringSecurityApp.repository.IEmployeeRepository;

@Service("customEmployeeDetailsService")
public class CustomEmployeeDetailsService implements UserDetailsService {
	
	private final IEmployeeRepository employeeRepository;// private final
															// UserRolesRepository
															// userRolesRepository;

	@Autowired
	public CustomEmployeeDetailsService(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee=employeeRepository.findByEmail(username);
		if(employee == null){
			throw new UsernameNotFoundException("No user present with email: "+username);
		}else{
			String userRole=employeeRepository.findUserRole(username);
			return new CustomEmployeeDetails(employee,userRole);
		}
	}
}
