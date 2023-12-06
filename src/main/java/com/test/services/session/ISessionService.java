package com.test.services.session;

import com.test.persistence.entities.session.SessionEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface ISessionService {

	/**
	 * Method used to get session list
	 * 
	 * @param command
	 * @return CustomPage of entity
	 */
	CustomPage<SessionEntity> getAll(PaginatorCommand command);

}
