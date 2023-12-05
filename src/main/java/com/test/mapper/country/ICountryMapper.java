package com.test.mapper.country;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controllers.country.dto.CountryDTO;
import com.test.persistence.entities.country.CountryEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICountryMapper {

	CountryDTO toTestDto(CountryEntity entity);

	CountryEntity toTest(CountryDTO dto);

	CustomPage<CountryDTO> toDtoPage(CustomPage<CountryEntity> entityPage);

}
