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
	/*
	step1. add driver on pom.xml
	step2. application.properties
	step3. create entiry model
	step4. create jpa reposiroty, annotate as @Repository
	step5. create service interface and implementation
	step6. annotate repository and call findAll method
	step7. annotate service and call from controller
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
