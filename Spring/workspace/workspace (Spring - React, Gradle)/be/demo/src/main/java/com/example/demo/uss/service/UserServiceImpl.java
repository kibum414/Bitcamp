package com.example.demo.uss.service;

import org.springframework.stereotype.Service;

import com.example.demo.uss.repository.UserRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepositoryImpl repo;
	
	void test() {
		repo.test();
		System.out.print("abc");
		Math.random();
	}
}
