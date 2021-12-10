package com.stock.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.stock.entities.Product;

@Repository
public interface ProductRepository  extends PagingAndSortingRepository<Product, UUID>{
	Optional<Product> findById(UUID id);

}
