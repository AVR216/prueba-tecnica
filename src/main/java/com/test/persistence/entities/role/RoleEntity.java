package com.test.persistence.entities.role;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "\"Role\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleEntity {

	@Id
	private String id;
	
	@Column(name = "name")
	@Enumerated(EnumType.STRING)
	private RoleEnum name;
	
	@Column(name = "\"createdAt\"")
	private LocalDateTime createdAt;
	
}
