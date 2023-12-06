package com.test.persistence.repositories.country.constants;

public class CountryRepositoryConstants {

	public static final String CUSTOM_FIND_ALL = """
			SELECT ce FROM CountryEntity ce JOIN FETCH ce.users
			""";

	public static final String FIND_BY_USER = """
			SELECT ce FROM CountryEntity ce JOIN FETCH ce.users cu WHERE cu.id = :userId
			""";

	private CountryRepositoryConstants() {

	}

}
