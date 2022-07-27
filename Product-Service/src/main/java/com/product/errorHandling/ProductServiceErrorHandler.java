package com.product.errorHandling;

import java.util.Date;

import org.apache.http.HttpStatus;
import org.axonframework.commandhandling.CommandExecutionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ProductServiceErrorHandler {

	
	@ExceptionHandler(value= {IllegalStateException.class})
	public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex ,WebRequest request)
	{
		ErrorMessage message=new ErrorMessage(new Date(),ex.getMessage());
	   return new ResponseEntity<>(message,new HttpHeaders(),HttpStatus.SC_INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleOtherException(Exception ex ,WebRequest request)
	{
		ErrorMessage message=new ErrorMessage(new Date(),ex.getMessage());
	   return new ResponseEntity<>(message,new HttpHeaders(),HttpStatus.SC_NO_CONTENT);	
	}
	@ExceptionHandler(value= {CommandExecutionException.class})
	public ResponseEntity<Object> handleCommandExecutionException(CommandExecutionException ex ,WebRequest request)
	{
		ErrorMessage message=new ErrorMessage(new Date(),ex.getMessage());
	   return new ResponseEntity<>(message,new HttpHeaders(),HttpStatus.SC_NO_CONTENT);	
	}

	
}
