package com.stock.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.stock.entities.Category;
import com.stock.entities.Product;
import com.stock.repository.CategoryRepository;
import com.stock.repository.ProductRepository;
import com.stock.service.ProductService;

@Service
public class ProductImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public Optional<Product> createProduct(Product product) {
		product.setCategory(getParentCategories(product));
		return Optional.of(this.productRepository.save(product));
	}

	public Optional<Page<Product>> showProducts() {
		return Optional.of(this.productRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE)));
	}

	public Optional<Product> showProduct(UUID id) {
		return this.productRepository.findById(id);
	}

	@Override
	public boolean deleteProduct(UUID id) {
		this.productRepository.deleteById(id);
		if (!this.productRepository.findById(id).isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	public Optional<Product> updateProduct(Product product) {
		Optional<Product> optionalProd = this.productRepository.findById(product.getId());
		if (optionalProd.isPresent()) {
			Product updatedProduct = Product.builder().id(product.getId()).name(product.getName()).ean(product.getEan())
					.image(product.getImage()).packageWeight(product.getPackageWeight()).brand(product.getBrand())
					.price(product.getPrice()).discount(product.getDiscount()).description(product.getDescription())
					.category(getParentCategories(product)).country(product.getCountry()).build();
			return Optional.of(this.productRepository.save(updatedProduct));
		}
		return Optional.of(null);
	}

	private List<Category> getParentCategories(Product product) {
		List<Category> list = new ArrayList<>();
		product.getCategory().forEach(category -> {
			Optional<Category> foundCategory = this.categoryRepository.findById(category.getId());
			if (foundCategory.isPresent()) {
				list.add(foundCategory.get());
			}
		});
		return list;

	}

}
