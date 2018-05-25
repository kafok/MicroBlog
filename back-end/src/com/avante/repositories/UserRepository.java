package com.avante.repositories;

public class UserRepository {

	private static UserRepository instance = null;
	
	public static UserRepository get() {
		if(instance == null)
			instance = new UserRepository();
		
		return instance;
	}
	
	private UserRepository() {
		super();
	}
	
	
	
}
