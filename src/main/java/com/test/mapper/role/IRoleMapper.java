package com.test.mapper.role;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controllers.role.dto.RoleDTO;
import com.test.persistence.entities.role.RoleEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRoleMapper {

	RoleDTO toTestDto(RoleEntity entity);

	RoleEntity toTest(RoleDTO dto);

	CustomPage<RoleDTO> toDtoPage(CustomPage<RoleEntity> entityPage);

}
