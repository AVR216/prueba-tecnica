package com.test.mapper.session;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controllers.session.dto.SessionDTO;
import com.test.persistence.entities.session.SessionEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISessionMapper {

	SessionDTO toTestDto(SessionEntity entity);

	SessionEntity toTest(SessionDTO dto);

	CustomPage<SessionDTO> toDtoPage(CustomPage<SessionEntity> entityPage);

}
