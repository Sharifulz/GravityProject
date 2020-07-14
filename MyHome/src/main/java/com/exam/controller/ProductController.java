package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.ProductModel;
import com.exam.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	IProductService productService;
	
	@PostMapping("/product/add")
	public Map<String, Object> saveProduct(@RequestBody List<ProductModel> productList){
		Map<String, Object> map =productService.saveProduct(productList);
		return map;
	}
	
	@GetMapping("/product/getAll")
	public Map<String, Object> getAllProduct(){
		Map<String, Object> map =productService.getAllProduct();
		return map;
	}
	
}
