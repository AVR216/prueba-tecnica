package com.test.persistence.entities.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.test.persistence.entities.country.CountryEntity;
import com.test.persistence.entities.role.RoleEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "\"User\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserEntity {

	private static final String COUNTRY_USER = "\"public\".\"_CountryToUser\"";
	
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "email")
	private String email;

	@Column(name = "\"emailVerified\"")
	private LocalDateTime emailVerified;

	@Column(name = "\"termsAndConditionsAccepted\"")
	private LocalDateTime termsAndConditionsAccepted;

	private String name;

	private String image;

	private String position;

	@Column(name = "\"createdAt\"")
	private LocalDateTime createdAt;

	@Column(name = "\"updatedAt\"")
	private LocalDateTime updatedAt;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"roleId\"")
	private RoleEntity role;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = COUNTRY_USER, 
			joinColumns = @JoinColumn(name = "\"B\""), 
			inverseJoinColumns = @JoinColumn(name = "\"A\""))
	private Set<CountryEntity> countries;
}
