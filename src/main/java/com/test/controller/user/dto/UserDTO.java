package com.test.controller.user.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

	private String id;

	private String email;

	private String name;

	private String image;

	private String position;

	private LocalDateTime createdAt;

	private UserRoleDto role;
	
	private Set<UserCountryDTO> countries;

}
