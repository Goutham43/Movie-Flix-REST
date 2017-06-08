package io.sid.Movie_Flix.exception;

public class UserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = -8557953206032303262L;

	public UserAlreadyExistsException(String message){
		
		super(message);
		
	}
	
	public UserAlreadyExistsException(String message, Throwable cause){
		
		super(message, cause);
		
	}
}
