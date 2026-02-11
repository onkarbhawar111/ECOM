package com.example.demo.userController;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.userservice.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
  
	public final UserService service;
	
	
	
	public UserController(UserService service) {
		
		this.service = service;
	}


    @PostMapping
	public  ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO udto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(udto));
		
	}
}
