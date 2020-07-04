package com.exam.model;

import java.sql.Date;

public class ProductModel {
	
	private String prodName;
	
	private String prodDesc;
	
	private int unitPrice;
	
	private Date buyingDate;
	
	private String prodCatagory;
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Date getBuyingDate() {
		return buyingDate;
	}
	public void setBuyingDate(Date buyingDate) {
		this.buyingDate = buyingDate;
	}
	public String getProdCatagory() {
		return prodCatagory;
	}
	public void setProdCatagory(String prodCatagory) {
		this.prodCatagory = prodCatagory;
	}
	public ProductModel(String prodName, String prodDesc, int unitPrice, Date buyingDate, String prodCatagory) {
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.unitPrice = unitPrice;
		this.buyingDate = buyingDate;
		this.prodCatagory = prodCatagory;
	}
	
	public ProductModel() {}
	
	
}
