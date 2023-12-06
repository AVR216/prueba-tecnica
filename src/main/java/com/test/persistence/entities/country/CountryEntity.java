package com.test.persistence.entities.country;

import java.time.LocalDateTime;
import java.util.Set;

import com.test.persistence.entities.user.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class to define a Country structure
 * 
 * @author jhonvillalba
 *
 */

@Entity
@Table(name = "\"Country\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {

	@Id
	private String id;

	private String name;

	@Column(name = "\"createdAt\"")
	private LocalDateTime createdAt;

	@Column(name = "\"updatedAt\"")
	private LocalDateTime updatedAt;

	@ManyToMany(mappedBy = "countries", fetch = FetchType.LAZY)
	private Set<UserEntity> users;
}
