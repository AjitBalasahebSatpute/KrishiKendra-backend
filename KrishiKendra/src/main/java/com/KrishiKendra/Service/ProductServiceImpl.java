package com.KrishiKendra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KrishiKendra.DTO.ProductDto;
import com.KrishiKendra.Model.Product;
import com.KrishiKendra.Repository.ProductRepository;
import com.KrishiKendra.Exception.*;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository= productRepository;
	}
	

	@Override
	public Product createProduct(ProductDto productDto) throws DatabaseConnectionExeption {
		
		try {
			Product product = new Product();
			product.setproductName(productDto.getProductName().toLowerCase());
			product.setBulkQuantity(productDto.getBulkQuantity());
			product.setImagePath(productDto.getImagePath());
			product.setPrice(productDto.getPrice());
			product.setProductSize(product.getProductSize());
			product.setVendorId(productDto.getVendorId());
			
			
			return this.productRepository.save(product);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseConnectionExeption("Error While Creating Record");
		}
		
	}


	@Override
	public List<Product> searchProducts(String query) throws DatabaseConnectionExeption {
		try {
			return this.productRepository.searchByProductName(query);
//			return this.productRepository.findAll();
		}catch(Exception e) {
			throw new DatabaseConnectionExeption("Connection error while searching in DB");
		}
	}



}
