package com.stock.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.responseData.CrudResponseData;
import com.stock.entities.Category;
import com.stock.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/category")
public class CategoryController  extends CrudResponseData<Category> {

	@Autowired 
	private CategoryService categoryService;
	
	@Operation(description = "Create new category for products", summary = "Create new category")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@PostMapping(value = "/createCategory")	
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
		return this.create(this.categoryService.createCategory(category));
	}
	
	@Operation(description = "Get all available categories for products", summary = "Get all categories")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@GetMapping(value = "/getAllCategories")	
	public ResponseEntity<Page<Category>> showCategories() {
		return this.readAllByPage(this.categoryService.showCategories());
	}
	
	@Operation(description = "Get all available sub categories for products", summary = "Get sub categories")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@GetMapping(value = "/getSubCategories")	
	public ResponseEntity<Page<Category>> showSubCategories() {
		return this.readAllByPage(this.categoryService.showSubCategories());
	}
	
	@Operation(description = "Get all available parent categories for products", summary = "Get parent categories")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@GetMapping(value = "/getParentCategories")	
	public ResponseEntity<Page<Category>> showParentCategories() {
		return this.readAllByPage(this.categoryService.showParentCategories());
	}
	
	@Operation(description = "Find category by its ID", summary = "Find category")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@GetMapping(value = "/findCategoryById/{id}")
	public ResponseEntity<Category> showCategory(@PathVariable UUID id) {
		return this.readOne(this.categoryService.showCategory(id));
	}
	
	@Operation(description = "Delete category by its ID", summary = "Delete category")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable UUID id) {
		return this.delete(this.categoryService.deleteCategory(id));
	}
}
