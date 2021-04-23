package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(value="/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok(productRepository.save(product));
	}
}
