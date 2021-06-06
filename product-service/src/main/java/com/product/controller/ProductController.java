package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.Coupan;
import com.product.feignclient.CoupanClient;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CoupanClient coupanClient;
	
	@PostMapping(value="/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		//call coupan-service to consume couapn
		Coupan coupan = coupanClient.findByCode(product.getCode());
		product.setPrice(product.getPrice().subtract(coupan.getDiscount()));
		return ResponseEntity.ok(productRepository.save(product));
	}
}
