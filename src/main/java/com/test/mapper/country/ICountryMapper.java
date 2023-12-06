package com.test.mapper.country;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controller.country.dto.CountryDTO;
import com.test.persistence.entities.country.CountryEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICountryMapper {

	CountryDTO toCountryDto(CountryEntity entity);

	CountryEntity toCountry(CountryDTO dto);

	CustomPage<CountryDTO> toDtoPage(CustomPage<CountryEntity> entityPage);

}
