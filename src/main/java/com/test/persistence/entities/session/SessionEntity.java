package com.test.persistence.entities.session;

import java.time.LocalDateTime;

import com.test.persistence.entities.user.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class to define a Session structure
 * 
 * @author jhonvillalba
 *
 */

@Entity
@Table(name = "\"Session\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionEntity {

	@Id
	private String id;

	@Column(name = "\"sessionToken\"")
	private String sessionToken;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "\"userId\"")
	private UserEntity user;

	@Column(name = "\"expiresAt\"")
	private LocalDateTime expiresAt;

	@Column(name = "\"createdAt\"")
	private LocalDateTime createdAt;
}
