package com.spring.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
@Configuration
public class MovieInfoRestClient {

	
	@Autowired(required = true)
	WebClient webClient;
	
	private String moviesInfoUrl="http://localhost:9000/movieInfo";
	
	/** The logger. */
	Logger log = LoggerFactory.getLogger(MovieInfoRestClient.class);
	public Mono<MovieInfo> retrieveMovieInfo(String movieId){
		 var url = moviesInfoUrl.concat("/{id}");
		 
		return WebClient.create()              
		.get()
                .uri(url, movieId)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,clientResponse->{
                	if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND))
                	{
                		return Mono.error(new MoviesInfoClientException("there is no movie available for this id"+movieId,
                				clientResponse.statusCode().value()));
                	}
                	  return clientResponse.bodyToMono(String.class)
                        		.flatMap(response->Mono.error(new MoviesInfoClientException(response,
                        				clientResponse.statusCode().value())));
                      		})
                .onStatus(HttpStatus::is5xxServerError, (clientResponse -> {
                    log.info("Status code : {}", clientResponse.statusCode().value());
                    return clientResponse.bodyToMono(String.class)
                            .flatMap(response -> Mono.error(new MoviesInfoServerException(response)));
                }))
                
                .bodyToMono(MovieInfo.class)
                //.retry(3)
                .log();

    }
}
