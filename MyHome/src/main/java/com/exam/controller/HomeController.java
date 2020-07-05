package com.exam.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.IProductService;

@RestController
@CrossOrigin("*")
public class HomeController {

	@Autowired
	IProductService productService;
	
	
	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome called");
		return "Welcome from Root";
	}
	
	@GetMapping("/product")
	public Map<String, Object> getAllProduct() {
		Map<String, Object> map = productService.getAllProductAndCustomer();
		return map;
	}
	
	
}
