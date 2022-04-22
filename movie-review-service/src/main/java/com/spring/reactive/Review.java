package com.spring.reactive;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Review.
 */
@Document
public class Review {
   
	  /** The review id. */
  	@Id
	private String reviewId;
	
	/** The movie info id. */
	private Long movieInfoId;
	
	/** The comments. */
	private String comments;
	
	/** The rating. */
	private Double rating;
	
	/**
	 * Instantiates a new review.
	 *
	 * @param reviewId the review id
	 * @param movieInfoId the movie info id
	 * @param comments the comments
	 * @param rating the rating
	 */
	public Review(String reviewId, Long movieInfoId, String comments, Double rating) {
		super();
		this.reviewId = reviewId;
		this.movieInfoId = movieInfoId;
		this.comments = comments;
		this.rating = rating;
	}
	
	/**
	 * Instantiates a new review.
	 */
	public Review() {
		super();
	}
	
	/**
	 * Gets the review id.
	 *
	 * @return the review id
	 */
	public String getReviewId() {
		return reviewId;
	}
	
	/**
	 * Sets the review id.
	 *
	 * @param reviewId the new review id
	 */
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	
	/**
	 * Gets the movie info id.
	 *
	 * @return the movie info id
	 */
	public Long getMovieInfoId() {
		return movieInfoId;
	}
	
	/**
	 * Sets the movie info id.
	 *
	 * @param movieInfoId the new movie info id
	 */
	public void setMovieInfoId(Long movieInfoId) {
		this.movieInfoId = movieInfoId;
	}
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	
	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}
	
	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}
}
