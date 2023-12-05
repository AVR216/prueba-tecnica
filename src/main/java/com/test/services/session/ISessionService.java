package com.test.services.session;

import com.test.persistence.entities.session.SessionEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface ISessionService {

	CustomPage<SessionEntity> getAll(PaginatorCommand command);

}
