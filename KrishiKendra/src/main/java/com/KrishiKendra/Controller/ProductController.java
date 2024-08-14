package com.KrishiKendra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KrishiKendra.DTO.ProductDto;
import com.KrishiKendra.DTO.ResponseDto;
import com.KrishiKendra.Exception.DatabaseConnectionExeption;
import com.KrishiKendra.Model.Product;
import com.KrishiKendra.Service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value ="product/")
@CrossOrigin
public class ProductController {
	
	private ProductService prouductService ;
	
	@Autowired
	 ProductController(ProductService productService){
		this.prouductService= productService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<ResponseDto> CreateProduct(@RequestBody ProductDto productDto) throws DatabaseConnectionExeption {
		
		try {
			ResponseDto response = new ResponseDto();
			response.setMsg("Record Created");
			response.setStatusCode(HttpStatus.CREATED.value());
			this.prouductService.createProduct(productDto);
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseConnectionExeption(e.getMessage());
		}

	
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam(required = false) String query) throws Exception{
		try {
			return new ResponseEntity<List<Product>>(this.prouductService.searchProducts(query), HttpStatus.OK);
		}
		catch(Exception e) {
			throw new DatabaseConnectionExeption(e.getMessage());
		}
	}
	
	

}
