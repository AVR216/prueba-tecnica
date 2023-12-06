package com.test.controller.usermonitoring.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class UserMonitoringByDateDTO {
	
	@NotBlank
	@Email
	private String email;

	@NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate startDate;

	@NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endDate;

}
