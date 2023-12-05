package com.test.util.messages;

import com.test.exceptions.TestGenericException;

public class MessageUtil {

	private MessageUtil() {

	}

	public static TestGenericException buildException(MessagesEnum message) {
		return new TestGenericException(message.getCode(), message.name(), message.getMessage());
	}
}
