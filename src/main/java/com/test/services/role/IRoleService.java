package com.test.services.role;

import com.test.persistence.entities.role.RoleEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface IRoleService {

	CustomPage<RoleEntity> findAll(PaginatorCommand command);
	
}
