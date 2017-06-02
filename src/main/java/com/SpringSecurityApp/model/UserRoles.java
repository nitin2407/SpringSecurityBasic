package com.SpringSecurityApp.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = -661310019543372010L;
	
	@Id
	@Column(name="role_id")
	private int role_id;
	
	@Column
	private String role_name;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}
