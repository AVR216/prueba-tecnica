package com.test.configuration.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.exceptions.TestGenericException;
import com.test.util.messages.MessagesEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

	@ResponseBody
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ResponseMessage<Void>> handleException(Exception ex) {

		log.error(ex.getMessage(), ex);

		if (ex instanceof TestGenericException genericEx) {

			var responseMessage = new ResponseMessage<Void>();
			responseMessage.setCode(genericEx.getErrorCode());
			responseMessage.setMessage(genericEx.getMessage());

			return ResponseEntity.status(genericEx.getHttpCode()).body(responseMessage);
		}

		return ResponseEntity.internalServerError().body(new ResponseMessage<Void>(
				MessagesEnum.UNKNOWN_ERROR.name(), MessagesEnum.UNKNOWN_ERROR.getMessage(), null));
	}
}
