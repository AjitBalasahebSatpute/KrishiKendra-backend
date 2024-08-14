package com.KrishiKendra.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.KrishiKendra.DTO.ProductDto;
import com.KrishiKendra.Exception.DatabaseConnectionExeption;
import com.KrishiKendra.Model.Product;


//@Service
public interface ProductService {
	
	Product createProduct(ProductDto productDto) throws DatabaseConnectionExeption;
	List<Product> searchProducts(String queryKey) throws DatabaseConnectionExeption;
	
	

}
