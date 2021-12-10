package com.customer.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Customer;
import com.customer.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired CustomerRepository customerRepository;
	
	public void create(Customer customer) {
		
	}
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}
	
	public Optional<Customer> findById(UUID id) {
		return this.customerRepository.findById(id);
	}
	
	public void deleteById(UUID id) {
		this.customerRepository.deleteById(id);
	}
}
