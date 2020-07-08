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
	
	@GetMapping("/index")
	public String successfulLogin() {
		return "index";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/user/profile")
	public String userProfile() {
		return "profile";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	
	@GetMapping("/noaccess")
	public String noaccess() {
		return "noaccess";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
