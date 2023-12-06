package com.test.services.auth.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.persistence.entities.session.SessionEntity;
import com.test.persistence.entities.user.UserEntity;
import com.test.persistence.repositories.session.ISessionRepository;
import com.test.persistence.repositories.user.IUserRepository;
import com.test.services.auth.IAuthService;
import com.test.util.messages.ExceptionBuilder;
import com.test.util.messages.MessagesEnum;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

	private final IUserRepository userRepository;
	private final ISessionRepository sessionRepository;

	@Transactional
	@Override
	public String getSession(String email) {

		var user = getUser(email);

		return getSessionForUser(user.getId()).getSessionToken();
	}

	private UserEntity getUser(String email) {
		return this.userRepository.findByEmail(email)
				.orElseThrow(() -> ExceptionBuilder.buildException(MessagesEnum.INVALID_EMAIL));
	}

	private SessionEntity getSessionForUser(String userId) {
		return this.sessionRepository.findByUserId(userId)
				.orElseThrow(() -> ExceptionBuilder.buildException(MessagesEnum.INACTIVE_SESSION));
	}
}
