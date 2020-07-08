package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.CustomerModel;
import com.exam.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/customers")
	public List<CustomerModel> getAllCustomers() {
		List<CustomerModel> list = customerService.getCustomerList();
		return list;
	}
	
}
