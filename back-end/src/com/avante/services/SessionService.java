package com.avante.services;

public class SessionService {

	private static SessionService instance = null;
	
	public static SessionService get() {
		if(instance == null)
			instance = new SessionService();
		
		return instance;
	}
	
	private SessionService() {
		super();
	}
	
	
	
}
