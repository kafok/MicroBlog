package com.avante.repositories;

public class SessionRepository {

	private static SessionRepository instance = null;
	
	public static SessionRepository get() {
		if(instance == null)
			instance = new SessionRepository();
		
		return instance;
	}
	
	private SessionRepository() {
		super();
	}
	
	
	
}
