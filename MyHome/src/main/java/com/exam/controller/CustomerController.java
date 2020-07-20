package com.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dao.ICustomerDao;
import com.exam.model.CustomerModel;
import com.exam.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ICustomerDao customerDao;
	
	@PostMapping("/add")
	public Map<String, Object> saveCustomer(@RequestBody List<CustomerModel> customerList){
		Map<String, Object> map =customerService.saveCustomers(customerList);
		return map;
	}
	
	@GetMapping("/getAll")
	public Map<String, Object> getAllCustomers(){
		Map<String, Object> map =customerService.getAllCustomers();
		return map;
	}
	
	@GetMapping("/getById")
	public Map<String, Object> getCustomerById(){
		CustomerModel customer = customerDao.findById(1);
		
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		return map;
	}
	
}
