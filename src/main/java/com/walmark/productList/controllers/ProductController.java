package com.walmark.productList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walmark.productList.models.Product;
import com.walmark.productList.services.ProductService;



@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path = "/products/{search}", produces = "application/json")
	public ResponseEntity<List> getProducts(@PathVariable String search) {
		
		List<Product> products = productService.getProductBySearch(search);
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	
}
