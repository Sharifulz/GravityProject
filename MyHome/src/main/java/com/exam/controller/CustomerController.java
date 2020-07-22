package com.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	/*
	table api_validate
	id 
	endpoint
	api_key
	1 getAll/{username} 123456789ABC
	*/
	
	/*
	@PutMapping(path="/user/update/{username}", consumes= "application/json", produces= "application/json")
	public ResponseEntity<Map<String, Object>> updateUser(HttpServletRequest request, @RequestBody UsersModel user, @PathVariable("username") String username,
			@RequestHeader("latLng") String latLng, @RequestParam("api_key") String api_key) {
	*/
	
	@GetMapping("/getAll/{username}")
	public Map<String, Object> getAllCustomers(HttpServletRequest request, @PathVariable("username") String username, @RequestParam("api_key") String api_key){
		System.out.println("Username : "+ username);
		System.out.println("Api Key : "+ api_key);
		//select * from api_validate where endpoint=getAll/{username} and api_key=api_key
				
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
	
	@GetMapping("/getByName")
	public Map<String, Object> getCustomerByName(){
		List<CustomerModel> customer = customerDao.findByCustNameAndCustAge("Json Smith",25);
		
		Map<String, Object> map = new HashMap<>();
		map.put("customer", customer);
		return map;
	}
	
}
