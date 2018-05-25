package com.avante.services;

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
	
	
	
}
