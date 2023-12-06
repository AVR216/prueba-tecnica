package com.test.services.country;

import com.test.persistence.entities.country.CountryEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface ICountryService {

	/**
	 * Method used to get all countries
	 * 
	 * @param command
	 * @return CustomPage of entity
	 */
	CustomPage<CountryEntity> getAll(PaginatorCommand command);

	/**
	 * Method used to get all countries by user
	 * 
	 * @param command
	 * @param userId
	 * @return CustomPage of entity
	 */
	CustomPage<CountryEntity> findAllById(PaginatorCommand command, String userId);
}
