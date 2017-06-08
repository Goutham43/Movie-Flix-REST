package io.sid.Movie_Flix.exception;

public class MovieAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 4201550352560035390L;
	
	public MovieAlreadyExistsException(String message){
		super(message);
	}
	
	public MovieAlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}
	
}
