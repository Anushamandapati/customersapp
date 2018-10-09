package com.capgemini.customersapp.service;

import java.util.List;

import com.capgemini.customersapp.entity.Customers;
import com.capgemini.customersapp.exception.CustomerNotFoundException;

public interface CustomersService 
{
	public Customers addCustomer(Customers customer);
	public Customers getCustomerById(long customerId) throws CustomerNotFoundException;
	public List<Customers> getAllCustomers();
	public void deleteCustomerById(long customerId);

}
