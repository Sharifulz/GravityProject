package com.exam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.model.CustomerModel;

@Repository
public interface ICustomerDao extends JpaRepository<CustomerModel, Integer> {
	@Query("FROM CustomerModel WHERE id =:id")
	CustomerModel getCustomerById(@Param("id") int id);
	
	@Query("FROM CustomerModel WHERE custName =:custName AND custAge=:custAge")
	CustomerModel getCustomerByCustomerNameAndCustomerAge(@Param("custAge") int custAge,@Param("custName") String custName);

	
	@Query("FROM CustomerModel WHERE custName =?1 AND custAge=?2")
	CustomerModel getCustomerByCustomerNameAndCustomerAge2(int custAge, String custName);

	
	//custAge
	List<CustomerModel> findByCustNameAndCustAge(String custName, int custAge);
	
	CustomerModel findById(int id);
	
}
