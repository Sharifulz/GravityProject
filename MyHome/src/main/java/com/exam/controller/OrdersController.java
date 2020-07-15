package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.OrdersModel;
import com.exam.payload.OrdersViewModel;
import com.exam.service.IOrdersService;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	IOrdersService orderService;
	
	@PostMapping("/add")
	public Map<String, Object> saveOrders(@RequestBody List<OrdersViewModel> ordersList){
		Map<String, Object> map =orderService.saveOrders(ordersList);
		return map;
	}
	
	@GetMapping("/getAll")
	public Map<String, Object> getAllOrders(){
		Map<String, Object> map =orderService.getAllOrders();
		return map;
	}
	
}
