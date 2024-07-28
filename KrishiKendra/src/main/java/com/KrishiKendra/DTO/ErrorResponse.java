package com.KrishiKendra.DTO;

import org.springframework.stereotype.Component;

//@Component
public class ErrorResponse {
	String msg;
	int statusCode;
//	public ErrorResponse(String msg, int statusCode) {
//		super();
//		this.msg = msg;
//		this.statusCode = statusCode;
//	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
