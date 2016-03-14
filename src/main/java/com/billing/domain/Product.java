package com.billing.domain;

import java.io.Serializable;

 

public class Product implements Serializable{
 
	private static final long serialVersionUID = 1L;
	int itemid;
	String description;
	String category;
	double price;
	double sTaxinPercent;
	double servicetaxprice;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Product(int itemid, String description, String category, double price, double sTax) {
		super();
		this.itemid = itemid;
		this.description = description;
		this.category = category;
		this.price = price;
		this.sTaxinPercent = sTax;
		this.servicetaxprice = (price * sTax)/100;
	}

	public Product(int itemid, String category, double price, double sTax) {
		super();
		this.itemid = itemid;
		this.category = category;
		this.price = price;
		this.sTaxinPercent = sTax;
		this.servicetaxprice = (price * sTax)/100;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the itemid
	 */
	public int getItemid() {
		return itemid;
	}

	/**
	 * @param itemid
	 *            the itemid to set
	 */
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the sTaxinPercent
	 */
	public double getsTaxinPercent() {
		return sTaxinPercent;
	}

	/**
	 * @param sTaxinPercent the sTaxinPercent to set
	 */
	public void setsTaxinPercent(double sTaxinPercent) {
		this.sTaxinPercent = sTaxinPercent;
	}

	/**
	 * @return the servicetaxprice
	 */
	public double getServicetaxprice() {
		return servicetaxprice;
	}

	/**
	 * @param servicetaxprice the servicetaxprice to set
	 */
	public void setServicetaxprice(double servicetaxprice) {
		this.servicetaxprice = servicetaxprice;
	}

}
