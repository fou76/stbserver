package fr.univ.rouen.stbserver.util;

public class NotValidStbException extends RuntimeException {
	    public NotValidStbException(String message) {
	        super(message);
	    }
	    
	    public NotValidStbException(){
	        super("Validation error");
	    }

}
