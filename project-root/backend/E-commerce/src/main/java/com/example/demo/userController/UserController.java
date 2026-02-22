package com.example.demo.userController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

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
	private  ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO udto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(udto));
		
	}
    
    @GetMapping
    private ResponseEntity<List<UserResponseDTO>>  getAllUser(){
    	return ResponseEntity.ok(service.getAllUser());
    }
    
    
    @DeleteMapping("/{id}")
    private ResponseEntity<String>  deleteUser(@PathVariable int id){
    	
    	service.deleteUser(id);
    	
    	return ResponseEntity.ok("User Deleted Successfully");
    			
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<UserResponseDTO> updateUser(@PathVariable int id,@RequestBody UserRequestDTO rdto){
    	
    	
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.updateUser(id,rdto));
    }
    
    
} 
