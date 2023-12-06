package com.test.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.test.controller.user.dto.UserDTO;
import com.test.persistence.entities.user.UserEntity;
import com.test.util.pager.CustomPage;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

	UserDTO toUserDto(UserEntity entity);

	UserEntity toUser(UserDTO dto);

	CustomPage<UserDTO> toDtoPage(CustomPage<UserEntity> entityPage);
}
