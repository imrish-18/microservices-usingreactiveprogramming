package com.product.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Product;


/**
 * The Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

}
