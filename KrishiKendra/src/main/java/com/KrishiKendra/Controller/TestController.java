package com.KrishiKendra.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KrishiKendra.Model.User;

@RestController
public class TestController {

	
	@GetMapping("/test")
	public User test() {
		return new User("Mukind","Khapale","Dasur", "1234567890");
	}
}
