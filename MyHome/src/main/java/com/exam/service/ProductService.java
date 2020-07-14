package com.exam.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.IProductDao;
import com.exam.model.ProductModel;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductDao productDao;
	 
	@Override
	public Map<String, Object> saveProduct(List<ProductModel> productList) {
		Map<String, Object> map = new HashMap<>();
		List<ProductModel> list = new ArrayList<>();
		productList.forEach(prod->{
			list.add(productDao.save(prod));
		});
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> getAllProduct() {
		Map<String, Object> map = new HashMap<>();
		List<ProductModel> list = productDao.findAll();
		map.put("list", list);
		return map;
	}

}
