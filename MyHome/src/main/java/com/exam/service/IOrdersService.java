package com.exam.service;

import java.util.List;
import java.util.Map;

import com.exam.payload.OrdersViewModel;

public interface IOrdersService {
	public Map<String, Object> saveOrders(List<OrdersViewModel> ordersList);
	public Map<String, Object> getAllOrders();
}
