package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// set a specific response code when this exception is thrown, because if not, 500 status is always returned
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resource, int id) {
		
		super(resource + " with id = " + id + " was not found");
	}
	
	public ResourceNotFoundException(String resource, String id) {
		
		super(resource + " with id = " + id + " was not found");
	}
	
	
}
