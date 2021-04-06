package com.example.demo.uss.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uss.domain.User;
import com.example.demo.uss.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
	
	private final UserServiceImpl service;
	
	@PostMapping("/insert")
	public ResponseEntity<User> save(@RequestBody User user) {
		service.save(user);
		
		return null;
	}
}
