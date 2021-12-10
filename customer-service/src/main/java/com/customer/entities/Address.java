package com.customer.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_location")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
}
