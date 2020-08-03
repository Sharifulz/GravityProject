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
import com.exam.service.IApiKeyService;
import com.exam.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ICustomerDao customerDao;
	
	@Autowired
	IApiKeyService apiService;
	
	@PostMapping("/add")
	public Map<String, Object> saveCustomer(@RequestBody List<CustomerModel> customerList){
		Map<String, Object> map =customerService.saveCustomers(customerList);
		return map;
	}
	// http://localhost:9007/customer/getAll/user11?api_key=GRAVITY123456
	@GetMapping("/getAllByUsername/{username}")
	public Map<String, Object> getAllCustomers(HttpServletRequest request, @PathVariable("username") String username, @RequestParam("api_key") String api_key){
		Map<String, Object> map = new HashMap<>();
		String endpoint = "getAllByUsername/{username}";
		
		Map<String, Object> apiResult = apiService.getByEndpointAndApiKey(endpoint, api_key);
		
		if (apiResult.get("result").equals(true)) {
			map =customerService.getAllCustomersByUsername(username);
		}else {
			map.put("message", apiResult.get("message"));
		}
		
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
