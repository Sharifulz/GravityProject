package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.OrdersModel;

@Repository
public interface IOrdersDao extends JpaRepository<OrdersModel, Integer> {

}
