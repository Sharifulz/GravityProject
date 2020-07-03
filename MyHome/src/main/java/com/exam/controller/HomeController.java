package com.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome called");
		return "Welcome from Root";
	}
	
	@GetMapping("/a1")
	public String welcome1() {
		System.out.println("Welcome called");
		return "Welcome from home project, Day:1, Method:1";
	}
	@GetMapping("/a2")
	public String welcome2() {
		System.out.println("Welcome called");
		return "Welcome from home project, Day:1, Method:2";
	}
	
}
