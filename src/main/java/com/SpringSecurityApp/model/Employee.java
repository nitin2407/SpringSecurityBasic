package com.SpringSecurityApp.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="emp")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 5348855676888234218L;

	@Id
	@GeneratedValue()
	@Column(name="emp_id")
	private int emp_id;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="role_id")
	@OneToOne
	private UserRoles userRole;
	
	public Employee() {
	}

	
	public Employee(Employee employee) {
		this.emp_id = employee.emp_id;
		this.email = employee.email;
		this.password = employee.password;
		this.fname = employee.fname;
		this.lname = employee.lname;
		this.userRole = employee.userRole;
	}


	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public UserRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}

}