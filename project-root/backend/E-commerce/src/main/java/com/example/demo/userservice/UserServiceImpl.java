package com.example.demo.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    //Create new User
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
	
	//Response Dto
	private UserResponseDTO mapTOResponseDTO(Euser euser) {
		UserResponseDTO dto=new UserResponseDTO();
		dto.setUid(euser.getUid());
		dto.setFname(euser.getFname());
		dto.setLname(euser.getLname());
		dto.setEmail(euser.getEmail());
		return dto;
	}


    //Get USer
	@Override
	public List<UserResponseDTO> getAllUser() {
		List<Euser> listeuser=repository.findAll();
		
		List<UserResponseDTO> response=new ArrayList<UserResponseDTO>();
		
		for(Euser euser:listeuser) {
			UserResponseDTO dto = mapTOResponseDTO(euser);
			response.add(dto);
		}
		return response ;
	}


   //Delete user
	@Override
	public ResponseEntity<String> deleteUser(int id) {
		
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted Successfully");
		
	}


    //USer update 
	@Override
	public UserResponseDTO updateUser(int id ,UserRequestDTO rdto) {
		
		Euser user=repository.findById(id).orElseThrow(() ->new RuntimeException("User Not Found with this id-"+id));
		
		user.setFname(rdto.getFname());
		user.setLname(rdto.getLname());
		user.setEmail(rdto.getEmail());
		
		if(rdto.getPassword()!=null) {
			
			user.setPassword(rdto.getPassword());
		}
		
		
		
		
		
		
		return mapTOResponseDTO(repository.save(user));
	}
   
	

}
