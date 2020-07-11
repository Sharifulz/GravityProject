package com.exam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.model.OrdersModel;

@Repository
public interface IOrdersDao extends JpaRepository<OrdersModel, Integer> {
	
	//SELECT * FROM tbl_orders WHERE product_name='Soap'
	//@Query(value = "SELECT * FROM tbl_orders WHERE product_name='Soap'", nativeQuery = true)
	@Query("FROM OrdersModel WHERE productName=:productName")
	public List<OrdersModel> getAllSoaps(@Param("productName") String abc);
	
}
