package com.exam.service;

import java.util.List;
import java.util.Map;

import com.exam.model.CustomerModel;

public interface ICustomerService { 
	public Map<String, Object> saveCustomers(List<CustomerModel> customerList);
	public Map<String, Object> getAllCustomers();
}
