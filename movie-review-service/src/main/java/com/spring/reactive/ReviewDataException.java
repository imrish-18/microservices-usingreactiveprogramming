package com.spring.reactive;

// TODO: Auto-generated Javadoc
/**
 * The Class ReviewDataException.
 */
public class ReviewDataException extends RuntimeException{

	/** The message. */
	private String message;
	
    /**
     * Instantiates a new review data exception.
     *
     * @param s the s
     */
    public ReviewDataException(String s) {
        super(s);
        this.message=s;
    }
}
