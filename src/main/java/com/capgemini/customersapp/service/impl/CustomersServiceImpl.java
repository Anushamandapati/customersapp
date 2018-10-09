package com.capgemini.customersapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customersapp.entity.Customers;
import com.capgemini.customersapp.exception.CustomerNotFoundException;
import com.capgemini.customersapp.repository.CustomersRepository;
import com.capgemini.customersapp.service.CustomersService;
@Service
public class CustomersServiceImpl implements CustomersService
{
	@Autowired
	private CustomersRepository customersRepository;
	@Override
	public Customers addCustomer(Customers customer) {
		return customersRepository.save(customer);
	}

	@Override
	public Customers getCustomerById(long customerId) throws CustomerNotFoundException {
		try
		{
			Optional<Customers> optionalCustomer = customersRepository.findById(customerId);
			if(optionalCustomer.isPresent())
				return optionalCustomer.get();
			else
				return null;
		}
		catch(Exception e)
		{
			CustomerNotFoundException customerNotFoundException = new CustomerNotFoundException("Customer not found");
			customerNotFoundException.initCause(e);
			throw customerNotFoundException;
			
		}
		
	}

	@Override
	public List<Customers> getAllCustomers() {
		return customersRepository.findAll();
	}

	@Override
	public void deleteCustomerById(long customerId)
	{
		customersRepository.deleteById(customerId);
	}

}
