package com.exam.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.model.CustomerModel;

@Repository
@Transactional
public interface ICustomerDao extends JpaRepository<CustomerModel, Integer> {
	@Query("FROM CustomerModel WHERE id =:id")
	CustomerModel getCustomerById(@Param("id") int id);
	
	@Query("FROM CustomerModel WHERE custName =:custName AND custAge=:custAge")
	CustomerModel getCustomerByCustomerNameAndCustomerAge(@Param("custAge") int custAge,@Param("custName") String custName);

	
	@Query("FROM CustomerModel WHERE custName =?1 AND custAge=?2")
	CustomerModel getCustomerByCustomerNameAndCustomerAge2(int custAge, String custName);

	@Query(value ="SELECT DISTINCT(cust_age), cust_name FROM tbl_customer WHERE cust_age=:cust_age ", nativeQuery = true)
	public List<Object[]> getDistinctCustomerByCustomerAge(@Param("cust_age") int cust_age);
	
	//custAge
	List<CustomerModel> findByCustNameAndCustAge(String custName, int custAge);
	
	List<CustomerModel> findByUsername(String username);
	
	CustomerModel findById(int id);
	
}
