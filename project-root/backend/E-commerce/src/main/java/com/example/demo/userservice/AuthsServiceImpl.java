package com.example.demo.userservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.entity.Euser;
import com.example.demo.security.JwtUtil;
@Service
public class AuthsServiceImpl implements AuthService{
    
	public final UserRepository repository;
	public final BCryptPasswordEncoder passwordEncoder;
	public final JwtUtil jwtUtil;
	
	
	
	public AuthsServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
     
	//Register user
	@Override
	public String register(LoginRequestDTO dto) {
		Euser user=new Euser();
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		return "User Register Successfully";
	}
     
	
	//Login user
	@Override
	public String login(String email, String password) {
		Euser user=(Euser) repository.findByEmail(email).orElseThrow(()->new RuntimeException("User not fount by this email"));
		
		
		if(! passwordEncoder.matches(password, user.getPassword())) {
			throw new RuntimeException("Invalid Input");
		}
		
		return jwtUtil.generateToken(email);
	}

}
