package com.exam.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dao.IOrdersDao;
import com.exam.model.OrdersModel;
import com.exam.service.IOrdersService;

@RestController
public class OrdersController {
/*
 0. save/post an order
 1. get all orders
 2. get all customers information with orders
 3. get all products information with orders
 */
	
	@Autowired
	IOrdersService ordersService;
	
	@PostMapping("/order/add")
	public Map<String, Object> saveOrders(@RequestBody OrdersModel order){
		Map<String, Object> map =ordersService.saveOrder(order);
		return map;
	}
	
	@GetMapping("/order/getAll")
	public Map<String, Object> getAllOrders(){
		Map<String, Object> map =ordersService.getAllOrders();
		return map;
	}
	/*
	/create/{company_code}
	@PathVariable("company_code") String company_code, 
	
	/create?id=111
	@RequestParam("api_key") String api_key
	*/
	@GetMapping("/order/getAll/{productName}")
	public Map<String, Object> getAllSoaps(@PathVariable("productName") String productName){
		Map<String, Object> map =ordersService.getAllSoaps(productName);
		return map;
	}
	
}
