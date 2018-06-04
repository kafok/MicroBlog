package com.avante.services;

import java.sql.SQLException;

import com.avante.model.Session;
import com.avante.repositories.SessionRepository;

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
	
	
	public Session get(int id) throws SQLException {
		return SessionRepository.get().get(id);
	}
	
	public Session save(Session session) throws SQLException {
		return SessionRepository.get().insert(session);
	}
	
	public void delete(int id) {
//		SessionRepository.get().delete(id);
	}
}
