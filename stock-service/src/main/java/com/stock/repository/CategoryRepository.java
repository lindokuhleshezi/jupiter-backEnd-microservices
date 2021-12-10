package com.stock.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.stock.entities.Category;

@Repository
public interface CategoryRepository  extends PagingAndSortingRepository<Category, UUID>{
	Optional<Category> findById(UUID id);
	Page<Category> findCategoryByParentIdNotEmpty(Pageable pageable);
	Page<Category> findCategoryByParentIdIsEmpty(Pageable pageable);

}
