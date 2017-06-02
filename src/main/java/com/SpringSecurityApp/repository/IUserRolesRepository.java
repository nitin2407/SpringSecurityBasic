package com.SpringSecurityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurityApp.model.UserRoles;

public interface IUserRolesRepository extends JpaRepository<UserRoles, Integer> {
	
	
}
