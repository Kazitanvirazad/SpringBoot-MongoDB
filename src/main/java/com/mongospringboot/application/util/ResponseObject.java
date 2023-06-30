package com.mongospringboot.application.util;

public class ResponseObject {
	private boolean error;
	private String message;
	private Object data;

	public ResponseObject() {
		super();
	}

	public ResponseObject(boolean error, String message) {
		this();
		this.error = error;
		this.message = message;
	}

	public ResponseObject(boolean error, String message, Object data) {
		this();
		this.error = error;
		this.data = data;
		this.message = message;
	}

	public ResponseObject(boolean error, Object data) {
		this();
		this.error = error;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
