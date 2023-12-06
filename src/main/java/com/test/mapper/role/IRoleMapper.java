package com.test.mapper.role;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controller.role.dto.RoleDTO;
import com.test.persistence.entities.role.RoleEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRoleMapper {

	RoleDTO toRoleDto(RoleEntity entity);

	RoleEntity toRole(RoleDTO dto);

	CustomPage<RoleDTO> toDtoPage(CustomPage<RoleEntity> entityPage);

}
