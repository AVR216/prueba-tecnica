package com.test.mapper.session;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controller.session.dto.SessionDTO;
import com.test.persistence.entities.session.SessionEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISessionMapper {

	SessionDTO toSessionDto(SessionEntity entity);

	SessionEntity toSession(SessionDTO dto);

	CustomPage<SessionDTO> toDtoPage(CustomPage<SessionEntity> entityPage);

}
