package com.avante.excetions;

public class HttpResponseException extends RuntimeException {

	
	private static final long serialVersionUID = -1535485378019942021L;
	private int status;

	
	public HttpResponseException(int status) {
		super();
		this.status = status;
	}


	public int getStatus() {
		return status;
	}
	
}
