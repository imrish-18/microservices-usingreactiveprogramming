package com.spring.reactive;

// TODO: Auto-generated Javadoc
/**
 * The Class ReviewNotFoundException.
 */
public class ReviewNotFoundException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The message. */
    private String message;
    
    /** The ex. */
    private Throwable ex;

    /**
     * Instantiates a new review not found exception.
     *
     * @param message the message
     * @param ex the ex
     */
    public ReviewNotFoundException( String message, Throwable ex) {
        super(message, ex);
        this.message = message;
        this.ex = ex;
    }

    /**
     * Instantiates a new review not found exception.
     *
     * @param message the message
     */
    public ReviewNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}