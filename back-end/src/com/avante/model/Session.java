package com.avante.model;

import java.time.LocalDate;
import java.util.Date;

public class Session extends Domain{
	private String cookies;
	private Date fecha;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
