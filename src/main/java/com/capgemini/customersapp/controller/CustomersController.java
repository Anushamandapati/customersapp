package com.capgemini.customersapp.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customersapp.entity.Customers;
import com.capgemini.customersapp.exception.CustomerNotFoundException;
import com.capgemini.customersapp.service.CustomersService;

@RestController
public class CustomersController 
{
	private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);
	@Autowired
	private CustomersService customerService;

	@PostMapping("/cust")
	public ResponseEntity<Customers> addCustomer(@RequestBody Customers customer)
	{
		ResponseEntity<Customers> responseEntity = new ResponseEntity<Customers>(customerService.addCustomer(customer),HttpStatus.OK);
		logger.info("Customer added" +" "+responseEntity.getBody());
		return responseEntity;
	}
	
	@GetMapping("/cust/{customerId}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable long customerId) throws CustomerNotFoundException
	{
		ResponseEntity<Customers> responseEntity = new ResponseEntity<Customers>(customerService.getCustomerById(customerId),HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/cust")
	public List<Customers>  getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@DeleteMapping("/cust/{customerId}")
	public void deleteCustomerById(@PathVariable long customerId)
	{
		customerService.deleteCustomerById(customerId);
	}
}
