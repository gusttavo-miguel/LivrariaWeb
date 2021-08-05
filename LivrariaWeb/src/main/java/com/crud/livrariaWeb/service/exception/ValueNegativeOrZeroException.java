package com.crud.livrariaWeb.service.exception;

public class ValueNegativeOrZeroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValueNegativeOrZeroException(String msg) {
		super(msg);
	}

	
}
