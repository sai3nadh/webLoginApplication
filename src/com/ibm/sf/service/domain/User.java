package com.ibm.sf.service.domain;

import java.time.LocalDate;

public class User {
	private Integer userId;
	private String userName;
	private String password;
	private LocalDate createDate;
	private String email;
	
	public User() {
		
	}

	public User(Integer userId, String userName, String password, LocalDate createDate, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", createDate="
				+ createDate + ", email=" + email + "]";
	}
	
	
}
