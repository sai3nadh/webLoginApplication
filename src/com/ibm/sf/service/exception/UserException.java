package com.ibm.sf.service.exception;

public class UserException extends Exception{	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserException() {
		
	}
	
	public UserException(String message) {
		this.message=message;
	}

	@Override
	public String getMessage() {		
		return this.message;
	}
	
	
	
}
