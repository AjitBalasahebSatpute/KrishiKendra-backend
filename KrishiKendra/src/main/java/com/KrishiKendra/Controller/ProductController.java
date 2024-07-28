package com.KrishiKendra.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="product/")
public class ProductController {
	
	
	@GetMapping("test")
	public String test() {
		return "test completed!";
	}
	
	

}
