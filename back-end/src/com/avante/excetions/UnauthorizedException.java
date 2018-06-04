package com.avante.excetions;

public class UnauthorizedException extends HttpResponseException {

	
	private static final long serialVersionUID = 6347054369419337390L;

	public UnauthorizedException() {
		super(401);
	}

}
