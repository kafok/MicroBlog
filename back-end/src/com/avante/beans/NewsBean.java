package com.avante.beans;

import com.avante.model.News;

public class NewsBean {
	private int id;
	private int userId;
	private long date;
	private String title;
	private String description;
	
	
	public NewsBean() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public static NewsBean toBean(News news) {
		NewsBean res = new NewsBean();
		res.setId(news.getId());
		res.setUserId(news.getUserId());
		res.setTitle(news.getTitulo());
		res.setDescription(news.getDescripcion());
		res.setDate(news.getFecha().getTime());
		
		return res;
	}
}
