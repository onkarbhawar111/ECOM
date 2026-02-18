package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginRequestDTO {
 
	private String password;
	private String email;
	
	public LoginRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginRequestDTO(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
