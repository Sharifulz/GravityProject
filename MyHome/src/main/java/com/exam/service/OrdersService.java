package com.exam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ICustomerDao;
import com.exam.dao.IOrdersDao;
import com.exam.model.CustomerModel;
import com.exam.model.OrdersModel;

@Service
public class OrdersService implements IOrdersService{
	
	@Autowired
	IOrdersDao ordersDao;
	
	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public Map<String, Object> saveOrder(OrdersModel order){
		Map<String, Object> orderMap = new HashMap<>();
		OrdersModel ord = ordersDao.save(order);
		orderMap.put("order", ord);
		return orderMap;
	}

	@Override
	public Map<String, Object> getAllOrders() {
		Map<String, Object> orderMap = new HashMap<>();
		List<OrdersModel> list = ordersDao.findAll();
		orderMap.put("orders", list);
		return orderMap;
	}

	@Override
	public Map<String, Object> getAllSoaps(String prouctName) {
		Map<String, Object> orderMap = new HashMap<>();
		List<OrdersModel> list = null;
		try {
			list = ordersDao.getAllSoaps(prouctName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<CustomerModel> customerList = null;
	
			if (list!=null && list.size()>0) {
				try {
					customerList = customerDao.getCustomerById(Integer.parseInt(list.get(0).getCustomerId()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		orderMap.put("soapList", list);
		orderMap.put("customerList", customerList);
		return orderMap;
	}
}