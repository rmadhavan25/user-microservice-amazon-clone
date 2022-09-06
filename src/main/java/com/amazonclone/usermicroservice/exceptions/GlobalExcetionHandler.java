package com.amazonclone.usermicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.amazonclone.usermicroservice.models.ExceptionMessage;

@RestControllerAdvice
public class GlobalExcetionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ExceptionMessage> handleUserAlreadyExistsException(UserAlreadyExistsException uae){
		System.out.println(uae.getMessage());
		return new ResponseEntity<ExceptionMessage>(new ExceptionMessage(uae.getMessage(), 409), HttpStatus.CONFLICT);
	}

}
