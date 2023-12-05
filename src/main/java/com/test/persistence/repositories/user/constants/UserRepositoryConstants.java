package com.test.persistence.repositories.user.constants;

public class UserRepositoryConstants {

	public static final String CUSTOM_FIND_ALL = """
			SELECT ue FROM UserEntity ue JOIN FETCH ue.role JOIN FETCH ue.countries
			""";

	private UserRepositoryConstants() {

	}
}
