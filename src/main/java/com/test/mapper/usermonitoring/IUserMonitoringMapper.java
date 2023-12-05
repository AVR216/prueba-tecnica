package com.test.mapper.usermonitoring;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controllers.usermonitoring.dto.UserMonitoringDTO;
import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMonitoringMapper {

	UserMonitoringDTO toTestDto(UserMonitoringEntity entity);

	UserMonitoringEntity toTest(UserMonitoringDTO dto);

	CustomPage<UserMonitoringDTO> toDtoPage(CustomPage<UserMonitoringEntity> entityPage);
}
