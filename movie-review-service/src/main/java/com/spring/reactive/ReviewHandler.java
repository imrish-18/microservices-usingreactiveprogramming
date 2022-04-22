package com.spring.reactive;

import java.util.function.Supplier;
import java.util.stream.Collectors;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class ReviewHandler.
 */
@Component
public class ReviewHandler {

	
	/** The repo. */
	@Autowired
	MovieReviewRepo repo;
	
	/** The validator. */
	@Autowired
    private Validator validator;
	
	/** The review validator. */
	@Autowired(required = true)
	
	 private ReviewValidator reviewValidator;
	
	/** The logger. */
	Logger log = LoggerFactory.getLogger(ReviewHandler.class);
	
	/**
	 * Adds the review.
	 *
	 * @param request the request
	 * @return the mono
	 */
	public Mono<ServerResponse> addReview(ServerRequest request)
	{
		return request.bodyToMono(Review.class)
				.doOnNext(this::validate)
				.flatMap(repo::save)
				.flatMap(res->{
					return ServerResponse.status(HttpStatus.CREATED)
							.bodyValue(res);
				});
				
	}

	/**
	 * Gets the review.
	 *
	 * @param req the req
	 * @return the review
	 */
	public Mono<ServerResponse> getReview(ServerRequest req) {
		var reviewFlux=repo.findAll();
		return ServerResponse.ok().body(reviewFlux,ReviewHandler.class);
		
	}
	
	
	/**
	 * Update review.
	 *
	 * @param req the req
	 * @return the mono
	 */
	public Mono<ServerResponse> updateReview(ServerRequest req) {
		var reviewId=req.pathVariable("id");
		
		
		  return repo.findById(reviewId)
				  .switchIfEmpty(Mono.error(new ReviewNotFoundException("review not found for the given id "+reviewId)))
			. flatMap(review->req.bodyToMono(Review.class)
							.map(res->{
								res.setComments("awesome movie it was....");
								return res;
							}).
							flatMap(repo::save)
							.flatMap(res->ServerResponse.ok().bodyValue(res)))
			                 .switchIfEmpty(ServerResponse.notFound().build());
			                 
							
							
//		  
//		@SuppressWarnings("unchecked")
//		return  repo.findById(reviewId)
//				.switchIfEmpty(
//						Mono.error((Supplier<? extends Throwable>) 
//								new ReviewNotFoundException("review not found  fot the given id :"+reviewId)));
//		
//		return exitingReview.flatMap(review->req.bodyToMono(Review.class)
//				.map(res->{
//					res.setComments("awesome movie it was");
//					return res;
//				}).
//				flatMap(repo::save)
//				.flatMap(res->ServerResponse.ok()
//				.bodyValue(res)));
	}
	

	/**
	 * Delete review.
	 *
	 * @param req the req
	 * @return the mono
	 */
	public Mono<ServerResponse> deleteReview(ServerRequest req) {
		var reviewId=req.pathVariable("id");
		var exitingReview=repo.findById(reviewId);
		
		return exitingReview.flatMap(review->repo.deleteById(reviewId)
				.then(ServerResponse.noContent().build()));
	
	}
	
	 /**
 	 * Validate.
 	 *
 	 * @param review the review
 	 */
 	private void validate(Review review) {
	        Errors errors = new BeanPropertyBindingResult(review, "review");
	        reviewValidator.validate(review, errors);
	        if (errors.hasErrors()) {
	            var errorMessage = errors.getAllErrors()
	                    .stream()
	                    .map(error -> error.getCode() + " : " + error.getDefaultMessage())
	                    .sorted()
	                    .collect(Collectors.joining(", "));
	            log.info("errorMessage : {} ", errorMessage);
	            throw new ReviewDataException(errorMessage);
	            
	            
	            /*  var constraintViolations = validator.validate(review);
	            log.info("constraintViolations : {} ", constraintViolations);
	            if(constraintViolations.size() >0){
	                var errorMessage = constraintViolations.stream()
	                        .map(ConstraintViolation::getMessage)
	                        .collect(Collectors.joining(", "));
	                log.info("errorMessage : {} ", errorMessage);
	                throw new ReviewDataException(errorMessage);
	            }*/
	        }
	 }
}
