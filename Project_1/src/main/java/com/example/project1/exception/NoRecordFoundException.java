package com.example.project1.exception;

public class NoRecordFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordFoundException()
	{
		
	}
	
	public NoRecordFoundException(String msg) {
		super(msg);
	}
}
