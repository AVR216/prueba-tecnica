package com.test.exception;

import lombok.Getter;

/**
 * Class to define a general project exception
 * 
 * @author Jhon Villalba
 *
 */

@Getter
public class TestGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final int httpCode;
	private final String errorCode;
	private final String message;

	public TestGenericException(int httpCode, String errorCode, String message) {
		super(message);
		this.httpCode = httpCode;
		this.errorCode = errorCode;
		this.message = message;
	}
}
