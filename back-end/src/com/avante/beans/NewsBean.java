package com.avante.beans;

import com.avante.model.News;

public class NewsBean {
	private int id;
	private int userId;
	private String userName;
	private long fecha;
	private String titulo;
	private String descripcion;
	
	
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
	
	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public static NewsBean toBean(News news, String name) {
		NewsBean res = new NewsBean();
		res.setId(news.getId());
		res.setUserId(news.getUserId());
		res.setTitulo(news.getTitulo());
		res.setDescripcion(news.getDescripcion());
		res.setFecha(news.getFecha().getTime());
		res.setUserName(name == null || name.isEmpty() ? "Desconocido" : name);
		
		return res;
	}
}
