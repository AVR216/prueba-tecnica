package com.test.services.user;

import com.test.persistence.entities.user.UserEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface IUserService {

	/**
	 * method used to get all users
	 * 
	 * @param command
	 * @return CustomPage of user
	 */
	CustomPage<UserEntity> findAll(PaginatorCommand command);

	/**
	 * Method used to get user info by Id
	 * 
	 * @param id
	 * @return an entity
	 */
	UserEntity userData(String id);

	/**
	 * Method to get an user by email
	 * 
	 * @param email
	 * @return an entity
	 */
	UserEntity findByEmail(String email);
}
