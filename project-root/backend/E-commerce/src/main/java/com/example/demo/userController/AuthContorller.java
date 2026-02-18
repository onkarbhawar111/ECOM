package com.example.demo.userController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.entity.Euser;
import com.example.demo.userservice.AuthService;
@RestController
@RequestMapping("/auth")
public class AuthContorller {
    public final AuthService authService;
	
   
    public final LoginRequestDTO dto;
    
	public AuthContorller(AuthService authService,LoginRequestDTO dto) {
		this.authService=authService;
		this.dto =dto;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody LoginRequestDTO dto){
		
	  return ResponseEntity.ok(authService.register( dto));	
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequestDTO  dto){
		String token=authService.login(dto.getEmail(),dto.getPassword());
		
		return ResponseEntity.ok(token); 
		
	}
	
	
	}

