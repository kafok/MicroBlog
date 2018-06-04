package com.avante.beans;

import com.avante.model.User;

public class UserBean {
	private int id;
	private String email;
	private String name;
	private String profile;
	
	
	public UserBean() {
		super();
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public static UserBean toBean(User user) {
		UserBean res = new UserBean();
		res.setId(user.getId());
		res.setName(user.getName());
		res.setEmail(user.getProfile());
		res.setProfile(user.getProfile() == null || user.getProfile().isEmpty() ? "/default.jpg" : user.getProfile());
		
		return res;
	}
}
