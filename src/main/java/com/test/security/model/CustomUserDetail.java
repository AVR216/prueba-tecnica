package com.test.security.model;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUserDetail extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

	public CustomUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String userId) {
		super(username, password, authorities);
		this.userId = userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		CustomUserDetail that = (CustomUserDetail) o;
		return Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), userId);
	}
}
