package com.KrishiKendra.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.KrishiKendra.DTO.ErrorResponse;

//@ControllerAdvice
@SuppressWarnings("serial")
@RestControllerAdvice
public class GlobalExceptionHandler extends Exception{

//	
//	@ExceptionHandler(BadInputException.class)
//	public ResponseEntity<ErrorResponse>badInput(BadInputException e){
//		
//		return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.OK);
//	}
	
	 @SuppressWarnings("unchecked")
	@ExceptionHandler(BadInputException.class)
	    public ResponseEntity<ErrorResponse> badInput(BadInputException ex) {

//		 this is not working as construction injection
//		 ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		 
		 ErrorResponse response = new ErrorResponse();
		 response.setMsg(ex.getMessage());
		 response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		 
		 return new ResponseEntity<ErrorResponse>(response,HttpStatus.OK);
}
	 
	 @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
	 public ResponseEntity<ErrorResponse> methodNotAllowed(org.springframework.web.HttpRequestMethodNotSupportedException e){
		 ErrorResponse response =  new ErrorResponse();
		 response.setMsg("method not allowed");
		 response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		 return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST); 
	 }
}