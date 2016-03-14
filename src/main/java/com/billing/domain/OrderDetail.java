package com.billing.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderDetail implements Serializable{
 
	private static final long serialVersionUID = 1L;

	String orderNumber;
	
	double totalprice;
	
	double servicetax;
	
	ArrayList<Product> selectedProduct;
	
	
	public OrderDetail(String orderNumber, double totalprice, double servicetax, ArrayList<Product> selectedProduct) {
		super();
		this.orderNumber = orderNumber;
		this.totalprice = totalprice;
		this.servicetax = servicetax;
		this.selectedProduct = selectedProduct;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the selectedProduct
	 */
	public ArrayList<Product> getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(ArrayList<Product> selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the totalprice
	 */
	public double getTotalprice() {
		return totalprice;
	}

	/**
	 * @param totalprice the totalprice to set
	 */
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	/**
	 * @return the servicetax
	 */
	public double getServicetax() {
		return servicetax;
	}

	/**
	 * @param servicetax the servicetax to set
	 */
	public void setServicetax(double servicetax) {
		this.servicetax = servicetax;
	}
	
	
}
