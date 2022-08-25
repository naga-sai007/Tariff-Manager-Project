package com.virtusa.exception;

public class SqlIntegrityViolation extends Exception {

	private final String error;

	public SqlIntegrityViolation(String message) {
		super();
		this.error = message;
	}

	public String getError() {
		return error;
	}

}
