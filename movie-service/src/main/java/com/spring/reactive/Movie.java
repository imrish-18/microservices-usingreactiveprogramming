package com.spring.reactive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private MovieInfo movieInfo;
    private List<Review> reviewList;
    
    
	public Movie() {
		super();
	}
	
	public Movie(MovieInfo movieInfo2, List<Review> review) {
		// TODO Auto-generated constructor stub
		
		this.movieInfo=movieInfo2;
		this.reviewList=review;
	}
	public MovieInfo getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
    
    
}