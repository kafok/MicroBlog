package com.avante.services;

import com.avante.model.User;

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
	
	
	public User getPrincipal() {
		return null;
	}
	
	public User get(int id) {
		return null;
	}
	
	public User save(User user) {
		return null;
	}
}
