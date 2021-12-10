package com.stock.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stock.entities.Category;


public interface CategoryService {

	Optional<Category> createCategory(Category category);

	Optional<Page<Category>> showCategories();

	Optional<Category> showCategory(UUID id);
	
	boolean deleteCategory(UUID id);

	Optional<Page<Category>> showSubCategories();
	
	Optional<Page<Category>> showParentCategories();
}
