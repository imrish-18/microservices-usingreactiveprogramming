package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceApplication.
 */
@SpringBootApplication
@EnableMongoRepositories("com.product.repository")
@EnableEurekaClient
public class ProductServiceApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		
		System.out.println("this is product event driven microservice");
	}

}
