package com.test.services.user.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.persistence.entities.user.UserEntity;
import com.test.persistence.repositories.user.IUserRepository;
import com.test.services.models.PaginatorCommand;
import com.test.services.user.IUserService;
import com.test.util.messages.ExceptionBuilder;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;
import com.test.util.pager.PageRequestBuilder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

	private final IUserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public CustomPage<UserEntity> findAll(PaginatorCommand command) {

		var page = this.userRepository.customFindAll(PageRequestBuilder.buildPageRequest(command));

		return PageRequestBuilder.buildCustomPage(page, command);
	}

	@Transactional(readOnly = true)
	@Override
	public UserEntity userData(String id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> ExceptionBuilder.buildException(MessagesEnum.USER_NOT_FOUND));
	}

	@Transactional(readOnly = true)
	@Override
	public UserEntity findByEmail(String email) {
		return this.userRepository.findByEmail(email)
				.orElseThrow(() -> ExceptionBuilder.buildException(MessagesEnum.INVALID_EMAIL));
	}
}
