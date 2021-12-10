package com.stock.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stock.entities.Product;


public interface ProductService {
	
	Optional<Product> createProduct(Product product);

	 Optional<Page<Product>> showProducts();
	
	 Optional<Product> showProduct(UUID id);
	 
	 boolean deleteProduct(UUID id);
	 
	 Optional<Product> updateProduct(Product product);
}
