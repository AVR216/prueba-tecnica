package com.test.config.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.exception.TestGenericException;
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
	
	public static ResponseEntity<ResponseMessage<Void>> buildErrorResponse(TestGenericException ex) {

		var response = new ResponseMessage<Void>();
		response.setCode(ex.getErrorCode());
		response.setMessage(ex.getMessage());

		return ResponseEntity.status(ex.getHttpCode()).body(response);
	}
}
