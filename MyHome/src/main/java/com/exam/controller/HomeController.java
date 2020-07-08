package com.exam.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.IProductService;
import com.exam.service.ProductService;

@RestController
@CrossOrigin("*")
public class HomeController {

	@Autowired
	IProductService iproductService;
	/*
	 Controller --> Service --> Dao/Repository --> Query/Database
	 ModelMapping --> Service--> Controller -- Front End
	 */
	
	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome called");
		return "Welcome from Root";
	}
	
	@GetMapping("/product")
	public Map<String, Object> getAllProduct() {
		Map<String, Object> map = iproductService.getAllProductAndCustomer();
		return map;
	}
	
	
}
