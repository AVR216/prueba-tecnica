package com.test.persistence.repositories.country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.country.CountryEntity;

@Repository
public interface ICountryRepository extends PagingAndSortingRepository<CountryEntity, String> {

	@Query(value = "SELECT ce FROM CountryEntity ce JOIN FETCH ce.users")
	Page<CountryEntity> customFindAll(Pageable pageable);

	@Query(value = "SELECT ce FROM CountryEntity ce JOIN FETCH ce.users cu WHERE cu.id = :userId")
	Page<CountryEntity> findByUser(Pageable pageable, @Param("userId") String id);
}
