package com.customer.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.entities.Address;
import com.customer.repositories.AddressRepository;

public class AddressService {

	@Autowired AddressRepository addressRepository;
	
	public void create(Address address) {
		
	}
	public List<Address> findAll() {
		return this.addressRepository.findAll();
	}
	
	public Optional<Address> findById(UUID id) {
		return this.addressRepository.findById(id);
	}
	
	public void deleteById(UUID id) {
		this.addressRepository.deleteById(id);
	}
}
