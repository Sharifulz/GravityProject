package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}
	
	@GetMapping("/success")
	public String successfulLogin() {
		return "success";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
