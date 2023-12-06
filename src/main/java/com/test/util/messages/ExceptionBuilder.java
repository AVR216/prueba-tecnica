package com.test.util.messages;

import com.test.exception.TestGenericException;

/**
 * Class used to build exceptions
 * 
 * @author jhonvillalba
 *
 */

public class ExceptionBuilder {

	private ExceptionBuilder() {

	}

	public static TestGenericException buildException(MessagesEnum message) {
		return new TestGenericException(message.getCode(), message.name(), message.getMessage());
	}
}
