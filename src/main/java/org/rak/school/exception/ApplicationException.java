package org.rak.school.exception;

import lombok.Getter;
import org.rak.school.enums.ErrorCodes;

@Getter
public class ApplicationException extends RuntimeException{

	private final String code;

	public ApplicationException(String code, String message) {
		this(code, message, null);
	}

	public ApplicationException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ApplicationException(ErrorCodes errorCodes, Object... param) {
		this(errorCodes.getCode(), String.format(errorCodes.getMessage(), param), null);
	}
}
