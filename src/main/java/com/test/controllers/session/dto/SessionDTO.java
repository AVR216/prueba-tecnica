package com.test.controllers.session.dto;

import java.time.LocalDateTime;

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
public class SessionDTO {

	private String id;

	private String sessionToken;

	private SessionUserDTO user;

	private LocalDateTime expiresAt;

	private LocalDateTime createdAt;

}
