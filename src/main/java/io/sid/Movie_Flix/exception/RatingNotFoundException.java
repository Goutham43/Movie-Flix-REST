package io.sid.Movie_Flix.exception;

public class RatingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1732319810254424292L;
	
	public RatingNotFoundException(String message) {
		super(message);
	}
	
	public RatingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
