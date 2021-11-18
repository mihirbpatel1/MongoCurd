package com.spring.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// give advice to controller on how to respond if certain exceptions are thrown
@ControllerAdvice
public class GlobalExceptionHandler {
	
	// @ExceptionHandler -> provide a response to this specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		
		String path = request.getDescription(false).substring(4);
		
		// what data to return back in response body when exception is thrown
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), path);
		
		// construct response with 404 status and error details in body
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	


}






