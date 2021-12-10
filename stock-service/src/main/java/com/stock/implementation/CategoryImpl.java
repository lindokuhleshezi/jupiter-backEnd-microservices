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
import com.stock.repository.CategoryRepository;
import com.stock.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Optional<Category> createCategory(Category category) {	
		category.setParentId(getParentCategories(category.getParentId()));
		return Optional.of(this.categoryRepository.save(category));
	}

	@Override
	public Optional<Page<Category>> showCategories() {
		return Optional.of(this.categoryRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE)));
	}
	
	@Override
	public Optional<Page<Category>> showSubCategories() {
		return Optional.of(this.categoryRepository.findCategoryByParentIdNotEmpty(PageRequest.of(0, Integer.MAX_VALUE)));
	}
	
	@Override
	public Optional<Page<Category>> showParentCategories() {
		return Optional.of(this.categoryRepository.findCategoryByParentIdIsEmpty(PageRequest.of(0, Integer.MAX_VALUE)));
	}

	@Override
	public Optional<Category> showCategory(UUID id) {
		return this.categoryRepository.findById(id);
	}

	@Override
	public boolean deleteCategory(UUID id) {
		this.categoryRepository.deleteById(id);
		if(!this.categoryRepository.findById(id).isPresent()) {
			return true;
		}
		return false;
	}
	
	private List<Category> getParentCategories(List<Category> categories){
		List<Category> list = new ArrayList<>();
		categories.forEach(category ->{
			Optional<Category> foundCategory = this.categoryRepository.findById(category.getId());
			if(foundCategory.isPresent()) {
				list.add(foundCategory.get());
			}
		});
		return list;
		
	}

	

}
