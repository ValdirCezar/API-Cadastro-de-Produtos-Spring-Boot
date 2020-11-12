package com.valdir.apistore.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	DataIntegratyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegratyViolationException(String message) {
		super(message);
	}

}
