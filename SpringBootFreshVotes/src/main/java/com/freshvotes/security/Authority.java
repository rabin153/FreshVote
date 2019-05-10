package com.freshvotes.security;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.freshvotes.domain.BaseEntity;
import com.freshvotes.domain.User;

@Entity
public class Authority extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	// Authority given to the user like USER,ADMIN etc.
	private String authority;

	@ManyToOne
	private User user;

	@Override
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
