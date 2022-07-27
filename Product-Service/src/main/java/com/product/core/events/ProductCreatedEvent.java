package com.product.core.events;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {

	/** The product id. */
	@Id
	private String product_id;
	
	/** The product name. */
	private String product_Name;
	
	/** The product quantity. */
	private int product_Quantity;
	
	/** The product description. */
	private String product_description;
}
