package com.example.demo.userservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.Euser;

@Service
public class UserServiceImpl implements UserService{
    
	public final UserRepository repository;
	public final BCryptPasswordEncoder passwordEncoder;
	
	
	
	public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
		
		this.repository = repository;
		this.passwordEncoder=passwordEncoder;
	}



	@Override
	public UserResponseDTO createUser(UserRequestDTO udto) {
		Euser euser=new Euser();
		euser.setFname(udto.getFname());
		euser.setLname(udto.getLname());
		euser.setEmail(udto.getEmail());
		euser.setPassword(passwordEncoder.encode(udto.getPassword()));
		
		Euser saveUser=repository.save(euser);
		
		return mapTOResponseDTO(saveUser);
	}
	
	private UserResponseDTO mapTOResponseDTO(Euser euser) {
		UserResponseDTO dto=new UserResponseDTO();
		dto.setFname(euser.getFname());
		dto.setLname(euser.getLname());
		dto.setEmail(euser.getEmail());
		return dto;
	}


}
