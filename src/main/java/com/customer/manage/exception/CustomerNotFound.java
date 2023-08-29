package com.customer.manage.exception;

@SuppressWarnings("serial")
public class CustomerNotFound extends RuntimeException {
	 public CustomerNotFound(String message){
		    super(message);
		  }

	/*
	 * @Override public HttpHeaders getResponseHeaders() { // return response
	 * headers }
	 */
}