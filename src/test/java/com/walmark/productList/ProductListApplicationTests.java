package com.walmark.productList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.walmark.productList.models.Product;
import com.walmark.productList.services.ProductService;

@SpringBootTest
@RunWith(SpringRunner.class)

class ProductListApplicationTests {
	
	@Autowired
	private ProductService service;

	
	
	@Test
	public void getOnlyOneProductById() {
		
		List<Product> products = this.service.getProductBySearch("1");
		assertEquals(1, products.size());
		
	}
	
	@Test
	public void getSomeProductsByPalindrome() {
		
		List<Product> products = this.service.getProductBySearch("saas");
		assertTrue(products.size() > 1);
		
	}
	
	@Test
	public void getSomeProductsByPalindromeWithOff() {
		
		List<Product> products = this.service.getProductBySearch("saas");
		Product product = products.get(0);
		assertTrue(product.isOff());
		
	}
	
	@Test
	public void getOnlyOneProductByIdWithOutOff() {
		
		List<Product> products = this.service.getProductBySearch("1");
		Product product = products.get(0);
		assertFalse(product.isOff());
		
	}
	
	@Test
	public void getAllProductsByPalindromeWithOff() {
		
		List<Product> products = this.service.getProductBySearch("saas");
		for (Product product : products) {
			assertTrue(product.isOff());	
		}
	}

}
