package com.test.services.auth;

public interface IAuthService {

	/**
	 * Method used to get token session from database
	 * 
	 * @param email
	 * @return Token
	 */
	String getSession(String email);

}
