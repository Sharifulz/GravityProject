package com.exam.service;

import java.util.Map;

import com.exam.model.OrdersModel;

public interface IOrdersService {
	public Map<String, Object> saveOrder(OrdersModel order);
	public Map<String, Object> getAllOrders();
	public Map<String, Object> getAllSoaps(String productName);
}
