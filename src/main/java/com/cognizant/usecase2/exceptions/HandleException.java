package com.cognizant.usecase2.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleUserNotFound(UserNotFoundException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("Error", ex.getMessage());
		return errorMap;
	}
}
