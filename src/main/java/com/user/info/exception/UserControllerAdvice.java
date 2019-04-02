package com.user.info.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
	
	  @ExceptionHandler(MethodArgumentNotValidException.class) 
	  @ResponseStatus( HttpStatus.BAD_REQUEST)
	  public void methodArgumentNotValidException() {
		 
	  }
	  
	
	  
}
