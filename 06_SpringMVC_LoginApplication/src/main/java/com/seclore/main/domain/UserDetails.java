package com.seclore.main.domain;

public class UserDetails {
	private String userId;
	private String name;
	private String password;

	public UserDetails() {
		System.out.println("UserDetails default constructor");
	}

	public UserDetails(String userId, String name, String password) {
		System.out.println("UserDetails overloaded constructor");
		this.userId = userId;
		this.name = name;
		this.password = password;
	}

	public String getUserId() {
		System.out.println("getUserId");
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("setUserId");
		this.userId = userId;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public String getPassword() {
		System.out.println("getPassword");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setPassword");
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}

}
