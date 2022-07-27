package com.product.handler;

import org.axonframework.config.ProcessingGroup;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.core.events.ProductCreatedEvent;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@Component
@ProcessingGroup("product-group")
public class ProductEventHandler {

	@Autowired
	ProductRepository productRepository;
	
	public void on(ProductCreatedEvent event)
	{
		Product product=new Product();
		BeanUtils.copyProperties(event, product);
		productRepository.save(product);
	}
}
