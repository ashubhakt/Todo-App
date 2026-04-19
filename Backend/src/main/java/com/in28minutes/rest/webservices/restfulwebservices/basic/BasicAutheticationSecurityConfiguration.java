package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAutheticationSecurityConfiguration {

	//filter chain
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		
		 return http
	                .csrf(csrf -> csrf.disable()) 
	                .authorizeHttpRequests(
	                        auth -> auth
	                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	                        .anyRequest()
	                        .authenticated()
	                )
	                .httpBasic(Customizer.withDefaults())
	                .sessionManagement(
	                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                )
	                .build();
		}
}
