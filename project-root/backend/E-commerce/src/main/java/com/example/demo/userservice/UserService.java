package com.example.demo.userservice;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;

public interface UserService {

	

	UserResponseDTO createUser(UserRequestDTO udto);
   
	List<UserResponseDTO>  getAllUser();
     
	ResponseEntity<String> deleteUser(int id);

	
	UserResponseDTO updateUser(int id,UserRequestDTO rdto);
}
