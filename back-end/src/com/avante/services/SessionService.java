package com.avante.services;

import com.avante.model.Session;

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
	
	
	public Session get(int id) {
		return null;
	}
	
	public Session save(Session session) {
		return null;
	}
	
	public void delete(int id) {
		
	}
}
