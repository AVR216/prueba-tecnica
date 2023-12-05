package com.test.services.country.imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.persistence.entities.country.CountryEntity;
import com.test.persistence.repositories.country.ICountryRepository;
import com.test.services.country.ICountryService;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;
import com.test.util.pager.PageRequestBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

	private final ICountryRepository countryRepository;

	@Transactional(readOnly = true)
	@Override
	public CustomPage<CountryEntity> getAll(PaginatorCommand command) {

		var page = this.countryRepository.findAll(PageRequestBuilder.buildPageRequest(command));

		return PageRequestBuilder.buildCustomPage(page, command);
	}

}
