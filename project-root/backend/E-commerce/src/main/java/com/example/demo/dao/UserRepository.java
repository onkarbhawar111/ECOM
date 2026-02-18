package com.example.demo.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Euser;

public interface UserRepository  extends JpaRepository<Euser,Integer>{
  
    Optional<Euser>  findByEmail(String email);
}
