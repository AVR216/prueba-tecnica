package com.test.persistence.repositories.usermonitoring.constants;

public class UsermonitoringRepositoryConstants {

	public static final String CUSTOM_FIND_ALL = """
			SELECT ume FROM UserMonitoringEntity ume JOIN FETCH ume.user
			""";

	public static final String FIND_BY_USER_ID = """
			SELECT ume FROM UserMonitoringEntity ume JOIN FETCH ume.user u WHERE u.id = :userId
			""";

	public static final String FIND_BY_DATE_AND_EMAIL = """
			SELECT ume FROM UserMonitoringEntity ume JOIN FETCH ume.user u
			WHERE u.email = :email AND ume.createdAt BETWEEN :startDate AND :endDate
			""";

	private UsermonitoringRepositoryConstants() {

	}
}
