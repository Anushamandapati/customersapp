package com.capgemini.customersapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers
{
	@Id
	private long customerId;
	private String customerName;
	private String address;
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(long customerId, String customerName, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address + "]";
	}
	
	
}
