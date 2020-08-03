package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ICustomerDao;
import com.exam.model.CustomerModel;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public Map<String, Object> saveCustomers(List<CustomerModel> customerList) {
		Map<String, Object> map = new HashMap<>();
		List<CustomerModel> list = new ArrayList<>();
		customerList.forEach(cust->{
			list.add(customerDao.save(cust));
		});
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> getAllCustomers() {
		Map<String, Object> map = new HashMap<>();
		List<CustomerModel> list = customerDao.findAll();
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> getAllCustomersByUsername(String username) {
		Map<String, Object> map = new HashMap<>();
		List<CustomerModel> list = customerDao.findByUsername(username);
		if (list.size()>0) {
			map.put("list", list);
		}else {
			map.put("message", "No Such user found");
		}
		
		return map;
	}

}
