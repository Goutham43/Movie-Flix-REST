package io.sid.Movie_Flix.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 193821255069400001L;
	
	public UserNotFoundException(String message){
		
		super(message);
	
	}
	
	public UserNotFoundException(String message, Throwable cause){
		
		super(message, cause);
		
	}
	

}
