package com.exam.service;

import java.util.List;
import java.util.Map;

import com.exam.model.ProductModel;

public interface IProductService {
	public Map<String, Object> saveProduct(List<ProductModel> productList);
	public Map<String, Object> getAllProduct();
}
