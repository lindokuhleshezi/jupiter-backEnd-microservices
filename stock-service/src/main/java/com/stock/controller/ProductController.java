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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.responseData.CrudResponseData;
import com.stock.entities.Product;
import com.stock.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController extends CrudResponseData<Product> {
	
	@Autowired 
	private ProductService productService;
	
	@Operation(description = "Create new product", summary = "Find product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@PostMapping(value = "/createProduct")
	ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		return this.create(this.productService.createProduct(product));
	}
	
	@Operation(description = "Find all available products", summary = "Find product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@GetMapping(value = "/getAllProduct")
	ResponseEntity<Page<Product>> showProducts() {
		return this.readAllByPage(this.productService.showProducts());
	}
	
	@Operation(description = "Find product by its ID", summary = "Find product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@GetMapping(value = "/findProductById/{id}")
	ResponseEntity<Product> showProduct(@PathVariable UUID id) {
		return this.readOne(this.productService.showProduct(id));
	}
	
	@Operation(description = "Delete product by its ID", summary = "Delete product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable UUID id) {
		return this.delete(this.productService.deleteProduct(id));
	}
	
	@Operation(description = "Update existing product", summary = "Update product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"), @ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Not Found"), @ApiResponse(responseCode = "500", description = "Failure") })
	@PutMapping(value = "/updateProduct")
	ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
		return this.update(this.productService.updateProduct(product),product);
	}
}
