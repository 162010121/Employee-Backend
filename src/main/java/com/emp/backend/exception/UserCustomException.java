package com.emp.backend.exception;

public class UserCustomException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public String message;
	
	public UserCustomException(String message)
	{
		super(message);
	}

}
