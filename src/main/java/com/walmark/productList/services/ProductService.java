package com.walmark.productList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmark.productList.models.Product;
import com.walmark.productList.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getProductBySearch(String search) {
		return productRepository.getProductBySearch(search);
		
	}

	
	
	
}
