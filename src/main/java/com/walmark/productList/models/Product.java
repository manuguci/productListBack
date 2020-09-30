package com.walmark.productList.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "01-products")

public class Product {
	@Id
	String objectId;
	int id;
	String brand;
	String description;
	String image;
	int price;
	boolean off;
	
	
	
	
	
	
	public Product(String objectId, int id, String brand, String description, String image, int price) {
		super();
		this.objectId = objectId;
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
		this.off = false;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isOff() {
		return off;
	}
	public void setOff(boolean off) {
		this.off = off;
	}
	
	

}
