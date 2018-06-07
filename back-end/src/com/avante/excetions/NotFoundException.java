package com.avante.excetions;

public class NotFoundException extends HttpResponseException {
	
	private static final long serialVersionUID = 3221992654896004117L;

	public NotFoundException() {
		super(404);
	}
}
