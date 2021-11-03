package com.example.sigca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	String mensaje() {
		return "Bienvenido a SIGCA";
	}
}
