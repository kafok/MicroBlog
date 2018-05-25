package com.avante.services;

public class NewsService {

	private static NewsService instance = null;
	
	public static NewsService get() {
		if(instance == null)
			instance = new NewsService();
		
		return instance;
	}
	
	private NewsService() {
		super();
	}
	
	
	
}
