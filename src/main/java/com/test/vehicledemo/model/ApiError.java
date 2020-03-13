package com.test.vehicledemo.model;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private String message;

	public ApiError(final HttpStatus status, final String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(final HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}