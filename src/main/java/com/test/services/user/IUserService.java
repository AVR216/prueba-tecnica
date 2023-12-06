package com.test.services.user;

import com.test.persistence.entities.user.UserEntity;
import com.test.services.models.PaginatorCommand;
import com.test.services.models.UserData;
import com.test.util.pager.CustomPage;

public interface IUserService {
	
	CustomPage<UserEntity> findAll(PaginatorCommand command, UserData sessionData);
	
}
