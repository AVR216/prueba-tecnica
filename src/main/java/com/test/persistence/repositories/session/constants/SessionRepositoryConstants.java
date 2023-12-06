package com.test.persistence.repositories.session.constants;

public class SessionRepositoryConstants {

	public static final String FIND_BY_TOKEN = """
			SELECT s FROM SessionEntity s JOIN FETCH s.user su JOIN FETCH su.role WHERE s.sessionToken = :token
			""";

	private SessionRepositoryConstants() {

	}

}
