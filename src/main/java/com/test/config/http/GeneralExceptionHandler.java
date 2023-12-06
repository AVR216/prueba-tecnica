package com.test.config.http;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.exception.TestGenericException;
import com.test.util.messages.ExceptionBuilder;
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

		if (ex instanceof AccessDeniedException) {
			return ResponseMessageBuilder
					.buildErrorResponse(ExceptionBuilder.buildException(MessagesEnum.INVALID_ROLE));
		}

		if (ex instanceof MethodArgumentNotValidException) {
			return ResponseMessageBuilder.buildErrorResponse(ExceptionBuilder.buildException(MessagesEnum.BAD_REQUEST));
		}

		return ResponseEntity.internalServerError().body(new ResponseMessage<Void>(MessagesEnum.UNKNOWN_ERROR.name(),
				MessagesEnum.UNKNOWN_ERROR.getMessage(), null));
	}
}
