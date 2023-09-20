package com.workshop.martin.controllers.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private byte roleId;

	private String authority;

	public Role() {
		super();
	}

	public Role(String authority) {
		this.authority = authority;
	}

	public byte getRoleId() {
		return roleId;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
}
