package com.spring.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface MovieReviewRepo.
 */
@Repository
public interface MovieReviewRepo  extends ReactiveMongoRepository<Review, String>{

}
