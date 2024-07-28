package com.KrishiKendra.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="product_details")
public class Product extends BaseModel{
	
	int price; 
	int quantity;
	int bulkQuantity;
	String category, name, company, imagePath ;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBulkQuantity() {
		return bulkQuantity;
	}
	public void setBulkQuantity(int bulkQuantity) {
		this.bulkQuantity = bulkQuantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Product(int price, int quantity, int bulkQuantity, String category, String name, String company,
			String imagePath) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.bulkQuantity = bulkQuantity;
		this.category = category;
		this.name = name;
		this.company = company;
		this.imagePath = imagePath;
	}


}
