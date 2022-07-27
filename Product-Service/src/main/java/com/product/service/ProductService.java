package com.product.service;

import java.util.UUID;



import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.product.model.CreateCommandProduct;
import com.product.model.Product;
import com.product.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductService.
 */
@Service
@Validated
public class ProductService {

	/** The productrepository. */
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	Environment env;
	
    @Autowired
    CommandGateway gateway;

	/**
	 * Show string.
	 *
	 * @return the mono
	 */
	public Mono<String> showString() {
		return Mono.just("hello this is string ");
	}

	/**
	 * Creates the new product.
	 *
	 * @param product the product
	 * @return the mono
	 */
	public Mono<Product> createNewProduct(@Validated Product product) {
		return productrepository.save(product);
	}
	

	/**
	 * Creates the new product.
	 *
	 * @param product the product
	 * @return the mono
	 */
	public String createNewProductwithCommand( Product product) {
		
		 String returnValue="";
		
		CreateCommandProduct createCommandProduct=CreateCommandProduct.builder()
				.product_id(UUID.randomUUID().toString())
				.product_Name(product.getProduct_Name())
				.product_Quantity(product.getProduct_Quantity())
				.product_description(product.getProduct_description()).build();
		
		returnValue= gateway.sendAndWait(createCommandProduct);
		
//		try
//		{
//		  returnValue= gateway.sendAndWait(createCommandProduct);
//		}
//		catch(Exception ex)
//		{
//			returnValue=ex.getLocalizedMessage();
//		}
		
		return returnValue;
	}

	/**
	 * Gets the prouduct by id.
	 *
	 * @param id the id
	 * @return the prouduct by id
	 */
	public Mono<Product> getProuductById(String id) {
		return productrepository.findById(id);
	}

	/**
	 * Gets the all prouduct.
	 *
	 * @return the all prouduct
	 */
	public Flux<Product> getAllProuduct() {
		return productrepository.findAll();
	}
	
	/**
	 * Delete all product.
	 *
	 * @return the mono
	 */
	public Mono<Void> deleteAllProduct()
	{
		return productrepository.deleteAll();
	}
	
	/**
	 * Delete product by id.
	 *
	 * @param Id the id
	 * @return the mono
	 */
	public Mono<Void> deleteProductById(String Id)
	{
		return productrepository.deleteById(Id);
	}
}
