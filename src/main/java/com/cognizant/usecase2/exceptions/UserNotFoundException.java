package com.cognizant.usecase2.exceptions;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String msg)
	{
		super(msg);
	}

}
