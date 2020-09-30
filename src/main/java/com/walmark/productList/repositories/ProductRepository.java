package com.walmark.productList.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.walmark.productList.Utils.Util;
import com.walmark.productList.models.Product;

@Repository
public class ProductRepository{

	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Product> getProductBySearch(String search) {
		
		List<Product> products = new ArrayList<>();
		
		if (Util.isNumeric(search)) {
			
			products.addAll(getProduct(search));
			
		} else {
			
			products.addAll(this.getProducts(search));
		}
		
		return products;
	}
	
	private List<Product> getProducts(String search){
		
		Criteria brand 		= Criteria.where("brand").regex(".*"+ search +".*");
		Criteria description 	= Criteria.where("description").regex(".*"+ search +".*");
		Criteria criteria = new Criteria().orOperator(brand, description);	
		Query query = new Query(criteria);
		List<Product> products = mongoTemplate.find(query, Product.class);
		
		if ( Util.isPalindrome(search) ) {
			this.off50(products);
		}
		
		return products;
	}
	
	private List<Product> getProduct(String search){

		Query query = new Query( Criteria.where("id").is( Integer.parseInt(search)));
		return mongoTemplate.find(query, Product.class);
	}
	
	private List<Product> off50(List<Product> products){
		
		for (Product product : products) {
			product.setPrice(product.getPrice() / 2);
			product.setOff(true);
		}
		
		return products;
		
	}
	
}
