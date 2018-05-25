package com.avante.repositories;

public class NewsRepository {

	private static NewsRepository instance = null;
	
	public static NewsRepository get() {
		if(instance == null)
			instance = new NewsRepository();
		
		return instance;
	}
	
	private NewsRepository() {
		super();
	}
	
	
	
}
