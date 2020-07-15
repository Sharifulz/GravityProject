package com.exam.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_orders")
@Entity
public class OrdersModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "total")
	private double total;

	@Column(name = "due_amt")
	private double dueAmt;
	
	@Column(name = "paid_amt")
	private double paidAmt;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDueAmt() {
		return dueAmt;
	}

	public void setDueAmt(double dueAmt) {
		this.dueAmt = dueAmt;
	}

	public double getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(double paidAmt) {
		this.paidAmt = paidAmt;
	}

	public OrdersModel() {}
	
	
	
}
