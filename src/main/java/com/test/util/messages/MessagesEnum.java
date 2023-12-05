package com.test.util.messages;

import lombok.Getter;

@Getter
public enum MessagesEnum {
	
	// Later, a property file can be implemented containing the messages
	UNKNOWN_ERROR(500, "Ha ocurrido un error inesperado, por favor contacte al administrador"),
	JWT_USER_NOT_VALID(401, "El usuario no cuenta con permisios para ingresar a la aplicacion"),
	INVALID_ROLE(401, "El usuario no cuenta con permisos para realizar esta accion"),
	SUCCESSFULLY_OPERATION(200, "Operacion realizada con exito");

	private int code;
	private String message;

	private MessagesEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
