package com.avante.model;

import java.time.LocalDate;

public class Session extends Domain{
	private String cookies;
	private LocalDate fecha;
	private Integer userId;
	public Session() {
		// TODO Auto-generated constructor stub
	}
	public String getCookies() {
		return cookies;
	}
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
