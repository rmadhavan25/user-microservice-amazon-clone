package com.amazonclone.usermicroservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserDetails {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique=true)
	private String userName;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String phone;
	private String password;
	
	
	public UserDetails() {
		super();
	}
	public UserDetails(String userName, String email, String phone, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
