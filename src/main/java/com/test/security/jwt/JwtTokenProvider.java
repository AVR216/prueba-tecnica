package com.test.security.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.test.security.imp.UserDetailServiceImp;

@Component
public class JwtTokenProvider {

	private final UserDetailsService userService;
	
	public JwtTokenProvider(UserDetailServiceImp userService) {
		this.userService = userService;
	}
	
	
	public Authentication getAuthentication(String token) {
		UserDetails userDetail = userService.loadUserByUsername(token);
		return new UsernamePasswordAuthenticationToken(userDetail, "", userDetail.getAuthorities());
	}
	
}
