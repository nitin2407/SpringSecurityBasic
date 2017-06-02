package com.SpringSecurityApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.SpringSecurityApp.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{
	@Query("select e from Employee e where e.email = :email")
	Employee findByEmail(@Param("email")String email);
	
	@Query("select e.userRole.role_name from Employee e where e.email = :email")
	String findUserRole(@Param("email")String email);	
	
}
