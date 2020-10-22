package com.educandoweb.course.services.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.resources.exceptions.StandardError;

@ControllerAdvice // Intercepta as excessoes para tratar
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	// Essa anotação e para intercerptar qualquer excessao q for lançada e fazer o
	// tratamento
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	
	}
}
