package com.test.configuration.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.util.messages.MessagesEnum;

public class ResponseMessageBuilder {

	private ResponseMessageBuilder() {

	}

	public static <T> ResponseEntity<ResponseMessage<T>> buildResponse(T content, MessagesEnum messageEnum) {

		var response = new ResponseMessage<T>();
		response.setCode(messageEnum.name());
		response.setContent(content);
		response.setMessage(messageEnum.getMessage());

		return ResponseEntity.status(HttpStatus.valueOf(messageEnum.getCode())).body(response);
	}
}
