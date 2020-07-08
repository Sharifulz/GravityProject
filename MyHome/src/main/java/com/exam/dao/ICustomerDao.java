package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.CustomerModel;

@Repository
public interface ICustomerDao extends JpaRepository<CustomerModel, Integer>{

}
