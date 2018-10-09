package com.capgemini.customersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.customersapp.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>
{
	

}
