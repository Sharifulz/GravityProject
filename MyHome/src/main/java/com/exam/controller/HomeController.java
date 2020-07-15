package com.exam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String welcome(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}
	
	@RequestMapping("/next")
	public String nextPage(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		return "next";
	}
	
	@RequestMapping("/customer/create")
	public String createCustomer(Map<String, Object> model) {
		model.put("message", "CREATE CUSTOMER Reader !!");
		return "customer/create";
	}
	
}
