package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfigaration {
   
	@Autowired
	private JwtFilter jwtFilter;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		 http.csrf(csrf -> csrf.disable())										
         .authorizeHttpRequests(auth -> auth
                 .requestMatchers("/auth/**").permitAll()
                 .anyRequest().permitAll()
         )
         
         .sessionManagement(session ->
         session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         );
		 
		 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

         return http.build();
		 	
	}
}
