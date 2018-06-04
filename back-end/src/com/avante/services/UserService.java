package com.avante.services;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.avante.model.Session;
import com.avante.model.User;
import com.avante.repositories.UserRepository;

public class UserService {

	private static UserService instance = null;
	
	public static UserService get() {
		if(instance == null)
			instance = new UserService();
		
		return instance;
	}
	
	private UserService() {
		super();
	}
	
	
	public User getPrincipal(HttpServletRequest request) throws SQLException {
		int sessionId = 0;
		Cookie[] cookies = request.getCookies();
		if(cookies == null)
			return null;
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("session")) {
				sessionId = Integer.parseInt(cookie.getValue());
				break;
			}
		}
		
		Session session = SessionService.get().get(sessionId);
		if(session != null) 
			return this.get(session.getUserId());
		else
			return null;
	}
	
	public User get(int id) throws SQLException {
		return UserRepository.get().get(id);
	}
	
	public User get(String email) throws SQLException {
		return UserRepository.get().get(email);
	}
	
	public User save(User user) throws SQLException {
		return UserRepository.get().insert(user);
	}
}
