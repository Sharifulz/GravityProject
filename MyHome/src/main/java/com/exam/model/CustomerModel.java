package com.exam.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_customer")
@Entity
public class CustomerModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String custName;
	@Column
	private String custFatherName;
	@Column
	private String custMotherName;
	@Column
	private int custAge;
	@Column
	private Date custDOB;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustFatherName() {
		return custFatherName;
	}

	public void setCustFatherName(String custFatherName) {
		this.custFatherName = custFatherName;
	}

	public String getCustMotherName() {
		return custMotherName;
	}

	public void setCustMotherName(String custMotherName) {
		this.custMotherName = custMotherName;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public CustomerModel(String custName, String custFatherName, String custMotherName, int custAge, Date custDOB) {
		this.custName = custName;
		this.custFatherName = custFatherName;
		this.custMotherName = custMotherName;
		this.custAge = custAge;
		this.custDOB = custDOB;
	}

	public CustomerModel() {
	}

	
	
	
}
