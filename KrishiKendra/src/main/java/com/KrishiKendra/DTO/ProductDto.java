package com.KrishiKendra.DTO;

public class ProductDto {

 	String productName;
	String price; 
	int productSize;
	int bulkQuantity;
	int vendorId;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getProductSize() {
		return productSize;
	}
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}
	public int getBulkQuantity() {
		return bulkQuantity;
	}
	public void setBulkQuantity(int bulkQuantity) {
		this.bulkQuantity = bulkQuantity;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	String imagePath ;

}

