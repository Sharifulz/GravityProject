package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.model.CustomerModel;

@Repository
public interface ICustomerDao extends JpaRepository<CustomerModel, Integer> {
	@Query("FROM CustomerModel WHERE id =:id")
	CustomerModel getCustomerById(@Param("id") int id);
}
