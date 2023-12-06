package com.test.mapper.usermonitoring;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controller.usermonitoring.dto.UserMonitoringDTO;
import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMonitoringMapper {

	UserMonitoringDTO toUserMonitoringDto(UserMonitoringEntity entity);

	UserMonitoringEntity toUserMonitoring(UserMonitoringDTO dto);

	CustomPage<UserMonitoringDTO> toDtoPage(CustomPage<UserMonitoringEntity> entityPage);
}
