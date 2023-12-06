package com.test.persistence.entities.usermonitoring;

import java.time.LocalDateTime;

import com.test.persistence.entities.user.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class to define a UserMonitoring structure
 * 
 * @author jhonvillalba
 *
 */

@Entity
@Table(name = "\"UserMonitoring\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMonitoringEntity {

	@Id
	private String id;

	private Integer usage;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "\"userId\"")
	private UserEntity user;

	@Column(name = "\"createdAt\"")
	private LocalDateTime createdAt;
}
