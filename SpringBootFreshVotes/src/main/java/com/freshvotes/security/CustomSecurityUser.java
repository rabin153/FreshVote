package com.freshvotes.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.freshvotes.domain.User;

public class CustomSecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomSecurityUser() {
	}

	public CustomSecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getName());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return this.getAuthorities();
	}

	@Override
	public String getPassword() {
		// Returning the password set on password field of User class
		return this.getPassword();
	}

	@Override
	public String getUsername() {
		// Returning the name set on name field of User class
		return this.getUsername();
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
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
