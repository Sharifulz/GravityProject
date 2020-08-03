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
	private String username;
	
	@Column
	private String custFatherName;
	
	@Column
	private String custMotherName;
	
	@Column
	private int custAge;
	
	@Column
	private Date custDOB;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isActive;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CustomerModel(int id, String custName, String custFatherName, String custMotherName, int custAge,
			Date custDOB, boolean isActive) {
		this.id = id;
		this.custName = custName;
		this.custFatherName = custFatherName;
		this.custMotherName = custMotherName;
		this.custAge = custAge;
		this.custDOB = custDOB;
		this.isActive = isActive;
	}

	public CustomerModel() {
	}

	
	
	
}
