package com.spring.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReviewRestClient {

	@Autowired
	WebClient webClient;
	
	private String reviewsUrl="http://localhost:9001/v1/reviews/movies";
	/** The logger. */
	Logger log = LoggerFactory.getLogger(ReviewRestClient.class);
			
	
	public Flux<Review>  retrieveReviews()
	{
		
		return webClient.get()
		           .uri(reviewsUrl)
		           .retrieve()
		           .onStatus(HttpStatus::is4xxClientError, (clientResponse -> {
	                    log.info("Status code : {}", clientResponse.statusCode().value());
	                    if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)){
	                        return Mono.empty();
	                    }
	                    return clientResponse.bodyToMono(String.class)
	                            .flatMap(response -> Mono.error(new ReviewsClientException(response)));
	                }))
	                .onStatus(HttpStatus::is5xxServerError, (clientResponse -> {
	                    log.info("Status code : {}", clientResponse.statusCode().value());
	                    return clientResponse.bodyToMono(String.class)
	                            .flatMap(response -> Mono.error(new ReviewsServerException(response)));
	                }))
		           .bodyToFlux(Review.class);
		           
		
	}
}
