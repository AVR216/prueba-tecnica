package com.test.persistence.repositories.country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.country.CountryEntity;
import com.test.persistence.repositories.country.constants.CountryRepositoryConstants;

@Repository
public interface ICountryRepository extends PagingAndSortingRepository<CountryEntity, String> {

	@Query(value = CountryRepositoryConstants.CUSTOM_FIND_ALL)
	Page<CountryEntity> customFindAll(Pageable pageable);

	@Query(value = CountryRepositoryConstants.FIND_BY_USER)
	Page<CountryEntity> findByUser(Pageable pageable, @Param("userId") String id);
}
