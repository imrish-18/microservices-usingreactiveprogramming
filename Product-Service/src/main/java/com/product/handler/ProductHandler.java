package com.product.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.product.model.Product;
import com.product.service.ProductService;

import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductHandler.
 */
@Component
public class ProductHandler {
	
	/** The product service. */
	@Autowired
	ProductService productService;
	
	 /**
 	 * Gets the string.
 	 *
 	 * @param serverRequest the server request
 	 * @return the string
 	 */
 	public Mono<ServerResponse> getString(ServerRequest serverRequest) {
		   
		    return ServerResponse.ok().body(productService.showString(), String.class);
		  }
	 
	 /**
 	 * Creates the new product.
 	 *
 	 * @param serverRequest the server request
 	 * @return the mono
 	 */
 	public Mono<ServerResponse> createNewProduct(ServerRequest serverRequest) {
		 return serverRequest.bodyToMono(Product.class).flatMap(res->{
				return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
			body(productService.createNewProduct(res), Product.class);
			});
		  }
 	
 	public Mono<ServerResponse> createNewProductWithCommand(ServerRequest serverRequest) {
		 return serverRequest.bodyToMono(Product.class).flatMap(res->{
				return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
			body(productService.createNewProductwithCommand(res), String.class);
			});
		  }
	 
	 
	 /**
 	 * Gets the all product.
 	 *
 	 * @param serverRequest the server request
 	 * @return the all product
 	 */
 	public Mono<ServerResponse> getAllProduct(ServerRequest serverRequest) {
		   
		    return ServerResponse.ok().body(productService.getAllProuduct(), Product.class);
		  }
	 
	 /**
 	 * Gets the all product by id.
 	 *
 	 * @param serverRequest the server request
 	 * @return the all product by id
 	 */
 	public Mono<ServerResponse> getAllProductById(ServerRequest serverRequest) {
		   
		    return ServerResponse.ok().
		    		body(productService.getProuductById(serverRequest.pathVariable("id")), Product.class);
		  }
	
	 
}
