package com.cognizant.usecase2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorResponseHandler {
	//not required wrap it in response entity
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInputException ex)//return the errorResponse instead of map
	{
		//create an errorResponse class which includes message, httpstatus and send this errorResponse instead of map
		//setErrormessage into errorResponse ex.getmessage()
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(err.getHttpStatusCode()).body(err);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleIdNotFound(IdNotFoundException ex)
	{
		//create an errorResponse class which includes message, httpstatus and send this errorResponse instead of map
		//setErrormessage into errorResponse ex.getmessage()
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(err.getHttpStatusCode()).body(err);
	}

}
//