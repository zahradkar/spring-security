package com.workshop.martin.controllers.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;

	@Override
	public String getAuthority() {
		return null;
	}
}
