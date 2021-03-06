package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.model.ProductModel;

@Repository
public interface IProductDao extends JpaRepository<ProductModel, Integer>{
	
	@Query("FROM ProductModel WHERE id =:id")
	ProductModel getProductById(@Param("id") int id);
	
}
