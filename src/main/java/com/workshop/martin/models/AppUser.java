package com.workshop.martin.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class AppUser implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	@Column(length = 30)
	private String username;
	@Column(length = 30)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_junction", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> authorities;

	public AppUser() {
		super();
		this.authorities = new HashSet<Role>();
	}

	public AppUser(String username, String password, Set<Role> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO https://youtu.be/TeBt0Ike_Tk?t=2246
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO
		return true;
	}
}
