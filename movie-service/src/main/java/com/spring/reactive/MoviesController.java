package com.spring.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/movies")
public class MoviesController {
	
	@Autowired
	MovieInfoRestClient restClient;
	
	@Autowired
	ReviewRestClient reviewRestClient;

    @GetMapping("/{id}")
    public Mono<Movie> retrieveMovieById(@PathVariable("id") String movieId){
             return restClient.retrieveMovieInfo(movieId)
            		 .flatMap(movieInfo->{
            			var reviewListInfo=reviewRestClient.retrieveReviews()
            					 .collectList();
            			return reviewListInfo.map(review->new Movie(movieInfo,review));
            		 });
      
             
    }
}
