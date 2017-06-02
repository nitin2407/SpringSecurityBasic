package com.SpringSecurityApp.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomEmployeeDetails  extends Employee implements UserDetails{
	
	private static final long serialVersionUID = -5035406607041879130L;
	
	private String userRole;

	public CustomEmployeeDetails(Employee employee,String userRole){
		super(employee);
		this.userRole=userRole;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return AuthorityUtils.commaSeparatedStringToAuthorityList(userRole);
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getUsername(){
		return super.getEmail();
	}	

}
