package com.test.services.role.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.persistence.entities.role.RoleEntity;
import com.test.persistence.repositories.role.IRoleRepository;
import com.test.services.models.PaginatorCommand;
import com.test.services.role.IRoleService;
import com.test.util.pager.CustomPage;
import com.test.util.pager.PageRequestBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

	private final IRoleRepository roleRepository;

	@Transactional(readOnly = true)
	@Override
	public CustomPage<RoleEntity> findAll(PaginatorCommand command) {

		var page = roleRepository.findAll(PageRequestBuilder.buildPageRequest(command));

		return PageRequestBuilder.buildCustomPage(page, command);
	}
}
