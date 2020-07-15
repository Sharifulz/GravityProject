package com.exam.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ICustomerDao;
import com.exam.dao.IOrdersDao;
import com.exam.dao.IProductDao;
import com.exam.model.CustomerModel;
import com.exam.model.OrdersModel;
import com.exam.model.ProductModel;
import com.exam.payload.OrdersViewModel;

@Service
public class OrdersService implements IOrdersService {

	@Autowired
	IOrdersDao ordersDao;
	
	@Autowired
	ICustomerDao customerDao;
	
	@Autowired
	IProductDao productDao;
	
	@Override
	public Map<String, Object> saveOrders(List<OrdersViewModel> ordersList) {
		Map<String, Object> map = new HashMap<>();
		List<String> msg = new ArrayList<>();
		List<OrdersModel> list = new ArrayList<>();
		
		//Check 1 : is this user exist?
		//Check 2 : Is this product exist?
		//Calculation : Is this product exist?
		boolean isValidDataFound = true;
		for (int i = 0; i < ordersList.size(); i++) {
			
			String customerId = ordersList.get(i).getCustomerId();
			String productId = ordersList.get(i).getProductId();
			CustomerModel customer = null;
			ProductModel product = null;

			customer = customerDao.getCustomerById(Integer.parseInt(customerId));
			product = productDao.getProductById(Integer.parseInt(productId));
			
			if (customer==null) {
				isValidDataFound = false;
				msg.add("No such customer exist.");
			}
			if (product==null) {
				isValidDataFound = false;
				msg.add("No such product exist.");
			}
			
			if (isValidDataFound) {
				//----- Set user and product data from database
				double total = ordersList.get(i).getQuantity() * product.getUnitPrice();
				double due = total - ordersList.get(i).getPaidAmt();
				
				OrdersModel order = new OrdersModel();
				order.setCustomerId(customerId);
				order.setCustomerName(customer.getCustName());
				order.setProductId(productId);
				order.setProductName(product.getProdName());
				order.setOrderDate(new Date(System.currentTimeMillis()));
				order.setTotal(total);
				order.setDueAmt(due);
				
				list.add(ordersDao.save(order));
			}

		}
		
		map.put("list", list);
		map.put("msg", msg);
		return map;
	}

	@Override
	public Map<String, Object> getAllOrders() {
		Map<String, Object> map = new HashMap<>();
		List<OrdersModel> list = ordersDao.findAll();
		map.put("list", list);
		return map;
	}

}
