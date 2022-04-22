package com.spring.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieReviewRouter.
 */
@Configuration
public class MovieReviewRouter {

	
	/**
	 * Gets the allreview router.
	 *
	 * @param handler the handler
	 * @return the allreview router
	 */
	@Bean
	public RouterFunction<ServerResponse> getAllreviewRouter(ReviewHandler handler)
        {
		   return RouterFunctions.route()
				   .nest(RequestPredicates.path("/v1/reviews"),builder->{
					   builder.POST("",req->handler.addReview(req))
					   .GET("/movies",req->handler.getReview(req))
				       .PUT("/{id}",req->handler.updateReview(req))
				       .DELETE("/{id}",req->handler.deleteReview(req));
				   })
				   .build();
				  
		}
	
//	 
//	@Bean
//	public RouterFunction<ServerResponse> reviewRouter(ReviewHandler handler)
//        {
//		   return RouterFunctions.route().POST("/v1/reviews",req->handler.addReview(req)).build();
//		}
//	
//	@Bean
//	public RouterFunction<ServerResponse> getReviewRouter(ReviewHandler handler)
//        {
//		   return RouterFunctions.route().POST("/v1/reviews",req->handler.getReview(req)).build();
//		}
//	@Bean
//	public RouterFunction<ServerResponse> updateRouter(ReviewHandler handler)
//        {
//		   return RouterFunctions.route().PUT("/v1/reviews/{id}",req->handler.updateReview(req)).build();
//		}

	
}
