package io.sid.Movie_Flix.exception;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1418988734816943332L;
	
	public MovieNotFoundException(String message){
		super(message);
	}
	
	public MovieNotFoundException(String message, Throwable cause){
		super(message, cause);
	}

}
