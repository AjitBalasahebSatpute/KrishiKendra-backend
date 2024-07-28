package com.KrishiKendra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KrishiKendra.DTO.UserDTO;
import com.KrishiKendra.Exception.BadInputException;
import com.KrishiKendra.Model.User;
import com.KrishiKendra.Service.UserService;

@RestController
@RequestMapping("user/")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("add")
	public ResponseEntity<?> addUser(@RequestBody User user) throws Exception{
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("get/list")
	public ResponseEntity<List<User>> getUserList() throws Exception{
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

}


	