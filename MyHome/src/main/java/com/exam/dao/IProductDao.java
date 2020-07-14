package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.ProductModel;

@Repository
public interface IProductDao extends JpaRepository<ProductModel, Integer>{

}
