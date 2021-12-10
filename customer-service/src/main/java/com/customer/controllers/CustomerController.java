package com.customer.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entities.Customer;
import com.customer.events.CustomerCreatedEvent;
import com.customer.messaging.CustomerChannels;
import com.customer.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	private CustomerRepository customerRepository;
	private CustomerChannels customerChannels;

	@Autowired
	public CustomerController(CustomerRepository customerRepository, CustomerChannels customerChannels) {
		this.customerRepository = customerRepository;
		this.customerChannels = customerChannels;
	}
	
	@PostMapping("/create")
	public void saveCustomer(@RequestBody @Valid Customer customer) {
		Customer customerData = customerRepository.save(customer);
		CustomerCreatedEvent customerEvent = new CustomerCreatedEvent(customerData.getId());
		log.info("customerEvent " +  customerEvent);
		customerChannels.customerCreatedOut().send(MessageBuilder.withPayload(customerEvent).build());
	}
	
	@GetMapping
	public String test() {
		return "working";
	}
	
}
