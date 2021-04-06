package com.example.demo.cmm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.util.Proxy;

// @RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HomeController extends Proxy {
	// private final Proxy px;
	
	@GetMapping("/")
	public String init() {
		print.accept("================================");
		print.accept("======= Boot Initialized =======");
		print.accept("================================");
		
		return "Hello React";
	}
}
