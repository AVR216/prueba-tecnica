package com.test.security.imp;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.persistence.entities.user.UserEntity;
import com.test.persistence.repositories.session.ISessionRepository;
import com.test.util.messages.ExceptionBuilder;
import com.test.util.messages.MessagesEnum;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

	private final ISessionRepository sessionRepository;

	@Override
	public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {

		var session = sessionRepository.findBySessionToken(token);
		UserEntity userEntity = session
				.orElseThrow(() -> ExceptionBuilder.buildException(MessagesEnum.JWT_USER_NOT_VALID)).getUser();
		var roleName = userEntity.getRole().getName().toString();
		Collection<? extends GrantedAuthority> authorities = Collections
				.singleton(new SimpleGrantedAuthority(roleName));

		return new User(userEntity.getName(), "", authorities);
	}

}
