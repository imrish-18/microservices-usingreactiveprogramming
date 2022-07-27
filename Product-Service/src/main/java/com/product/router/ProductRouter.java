package com.product.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.product.handler.ProductHandler;


// TODO: Auto-generated Javadoc
/**
 * The Class ProductRouter.
 */
@Configuration
public class ProductRouter {

	
	/**
	 * Gets the string.
	 *
	 * @param productHandler the product handler
	 * @return the string
	 */
	@Bean
     public RouterFunction<ServerResponse> getString(ProductHandler productHandler)
        {
		  
		return RouterFunctions.route(RequestPredicates.GET("/getAll").and(RequestPredicates.
	    		  accept(MediaType.APPLICATION_JSON)), productHandler::getString);
		
		}
	
	
	/**
	 * Gets the by id.
	 *
	 * @param productHandler the product handler
	 * @return the by id
	 */
	@Bean
	  public RouterFunction<ServerResponse> getById(ProductHandler productHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/getById/{id}"), productHandler::getAllProductById);
	  }
	
	  /**
  	 * Postdata.
  	 *
  	 * @param productHandler the product handler
  	 * @return the router function
  	 */
	@Bean
	  public RouterFunction<ServerResponse> postEmp(ProductHandler productHandler)
	  {
	 return RouterFunctions.route(RequestPredicates.POST("/createProduct").
			 and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), productHandler::createNewProduct);
}
	
	  /**
  	 * Postdata.
  	 *
  	 * @param productHandler the product handler
  	 * @return the router function
  	 */
	@Bean
	  public RouterFunction<ServerResponse> createNewProductWithCommand(ProductHandler productHandler)
	  {
	 return RouterFunctions.route(RequestPredicates.POST("/createProductWithCommand").
			 and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), productHandler::createNewProductWithCommand);
}
}
