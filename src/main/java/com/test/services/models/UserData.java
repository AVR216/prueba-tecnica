package com.test.services.models;

import com.test.persistence.entities.role.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class used to define user data from session
 * 
 * @author jhonvillalba
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

	private RoleEnum role;
	private String id;

}
