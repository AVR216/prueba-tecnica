package com.test.services.session.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.persistence.entities.session.SessionEntity;
import com.test.persistence.repositories.session.ISessionRepository;
import com.test.services.models.PaginatorCommand;
import com.test.services.session.ISessionService;
import com.test.util.pager.CustomPage;
import com.test.util.pager.PageRequestBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionService implements ISessionService {

	private final ISessionRepository sessionRepository;

	@Transactional(readOnly = true)
	@Override
	public CustomPage<SessionEntity> getAll(PaginatorCommand command) {

		var page = this.sessionRepository.findAll(PageRequestBuilder.buildPageRequest(command));

		return PageRequestBuilder.buildCustomPage(page, command);
	}

}
