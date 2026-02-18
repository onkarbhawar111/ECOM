package com.example.demo.userservice;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.entity.Euser;

public interface AuthService {


	public String  register(LoginRequestDTO dto);

	public String login(String email, String password);

	

}
