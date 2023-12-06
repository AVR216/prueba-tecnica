package com.test.services.country;

import com.test.persistence.entities.country.CountryEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface ICountryService {

	CustomPage<CountryEntity> getAll(PaginatorCommand command);

	CustomPage<CountryEntity> findAllById(PaginatorCommand command, String id);
}
