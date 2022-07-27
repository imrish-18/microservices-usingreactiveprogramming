package com.product.model;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class CreateCommandProduct {

	/** The product id. */
	@Id
	@TargetAggregateIdentifier
	private String product_id;
	
	/** The product name. */
	private String product_Name;
	
	/** The product quantity. */
	private int product_Quantity;
	
	/** The product description. */
	private String product_description;
}
