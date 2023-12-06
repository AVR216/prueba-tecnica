package com.test.util.messages;

import lombok.Getter;

@Getter
public enum MessagesEnum {

	// Later, a property file can be implemented containing the messages
	UNKNOWN_ERROR(500, "Ha ocurrido un error inesperado, por favor contacte al administrador"),
	JWT_USER_NOT_VALID(401, "El usuario no cuenta con permisos para ingresar a la aplicacion"),
	INVALID_ROLE(401, "El usuario no cuenta con permisos para realizar esta accion"),
	SUCCESSFULLY_OPERATION(200, "Operacion realizada con exito"),
	INVALID_EMAIL(404, "Email no registrado en base de datos"),
	INACTIVE_SESSION(401, "El usuario no tiene una sesion activa"),
	USER_NOT_FOUND(404, "Informacion sobre el usuario no encontrada"),
	BAD_REQUEST(400,
			"El formato de la peticion no corresponde. El correo debe tener formato valido y las fechas deben cumplir con el siguiente: 2023-01-01"),
	INVALID_DATE(400, "La fecha final no puede ser mayor que la inicial");

	private int code;
	private String message;

	private MessagesEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
