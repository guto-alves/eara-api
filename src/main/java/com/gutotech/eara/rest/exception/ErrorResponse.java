package com.gutotech.eara.rest.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private int status;
	private String error;
	private List<String> fieldErrors = new ArrayList<>();
	private String message;
	private String path;

	public ErrorResponse() {
	}

	public ErrorResponse(HttpStatus status, String message, String path) {
		this.timestamp = new Date();
		this.status = status.value();
		this.error = status.getReasonPhrase();
		this.message = message;
		this.path = path;
	}

	public ErrorResponse(Date timestamp, int status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public ErrorResponse(Date timestamp, int status, String error, List<String> fieldErrors, String message,
			String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.fieldErrors = fieldErrors;
		this.message = message;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
