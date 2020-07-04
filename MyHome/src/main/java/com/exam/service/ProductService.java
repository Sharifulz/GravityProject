package com.exam.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.exam.model.CustomerModel;
import com.exam.model.ProductModel;
@Service
public class ProductService implements IProductService {

	@Override
	public Map<String, Object> getAllProductAndCustomer() {
		Map<String, Object> map = new HashMap<>();
		
		List<ProductModel>  list1 = Arrays.asList(new ProductModel("Soap", 
				"Lux Soap is best", 50, 
				new Date(System.currentTimeMillis()), "SOAP"),new ProductModel("Milk", 
						"Fresh Milk is best", 100, 
						new Date(System.currentTimeMillis()), "MILK"));
		
		
		List<CustomerModel>  list2 = new ArrayList<CustomerModel>();

		
		CustomerModel cust1 = new CustomerModel("Shariful Islam", 
				"Shafiqul Islam", "Aklima Begum", 25, 
				new Date(System.currentTimeMillis()));
		
		CustomerModel cust2 = new CustomerModel("Ariful Islam", 
				"Afiqul Islam", "Lima Begum", 25, 
				new Date(System.currentTimeMillis()));
		
		list2.add(cust1);
		list2.add(cust1);
		
		map.put("product", list1);
		map.put("customer", list2);
		return map;
	}

}
