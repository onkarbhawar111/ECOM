package com.example.demo.dto;

import jakarta.persistence.Column;

public class UserResponseDTO {   //for display not password
   
	private int uid;
	private String fname;
	private String lname;
	private String email;
	
	public UserResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserResponseDTO(int uid, String fname, String lname, String email) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserResponseDTO [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}
	
	
	
}
