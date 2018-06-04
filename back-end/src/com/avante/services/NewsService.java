package com.avante.services;

import java.util.Collection;

import com.avante.model.News;

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
	
	
	public News get(int id) {
		return null;
	}
	
	public Collection<News> list() {
		return null;
	}
	
	public News save(News news) {
		return null;
	}
	
	public void delete(int id) {
		
	}
}
