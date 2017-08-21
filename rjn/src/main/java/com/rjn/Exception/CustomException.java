package com.rjn.Exception;

public class CustomException extends Exception{
	
	public CustomException(String message){
		super(message);
	}
	
	public CustomException(){
		
	}
	
	public CustomException(Throwable exception){
		super(exception);
	}
	
	public CustomException(String message, Throwable exception){
		super(message,exception);
	}

}
