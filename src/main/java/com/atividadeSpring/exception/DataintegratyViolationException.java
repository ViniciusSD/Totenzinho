package com.atividadeSpring.exception;

public class DataintegratyViolationException  extends RuntimeException {
	
	static final long serialVersionUID = 1L;

	public DataintegratyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataintegratyViolationException(String message) {
		super(message);
	}
	
	

}
