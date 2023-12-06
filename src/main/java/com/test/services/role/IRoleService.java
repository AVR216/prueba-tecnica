package com.test.services.role;

import com.test.persistence.entities.role.RoleEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface IRoleService {

	/**
	 * Method used to get all roles
	 * 
	 * @param command
	 * @return CustomPage of entity
	 */
	CustomPage<RoleEntity> findAll(PaginatorCommand command);

}
