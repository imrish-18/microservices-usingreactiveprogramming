package com.product.model;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.product.core.events.ProductCreatedEvent;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Aggregate
public class ProductAggregate {

	@AggregateIdentifier
	private String product_id;

	/** The product name. */
	private String product_Name;

	/** The product quantity. */
	private int product_Quantity;

	/** The product description. */
	private String product_description;

	public ProductAggregate() {

	}

	@CommandHandler
	public ProductAggregate(CreateCommandProduct commandProduct) throws Exception {
		// validate create product command

		if (commandProduct.getProduct_description() == null) {
			throw new IllegalArgumentException("product description can not be null");
		}
		if (commandProduct.getProduct_Quantity() <= 0) {

			throw new IllegalArgumentException("product quantity can not be 0");
		}

		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		BeanUtils.copyProperties(commandProduct, productCreatedEvent);
		AggregateLifecycle.apply(productCreatedEvent);
		if(true) throw new Exception("an error took place in the createCommandProduct");

	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent)
	{
		this.product_description=productCreatedEvent.getProduct_description();
		this.product_id=productCreatedEvent.getProduct_id();
		this.product_Name=productCreatedEvent.getProduct_Name();
		this.product_Quantity=productCreatedEvent.getProduct_Quantity();
	}
}
