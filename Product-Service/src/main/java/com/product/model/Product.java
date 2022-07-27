package com.product.model;

import javax.annotation.Nonnull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
@Document
public class Product {
 
	/** The product id. */
	@Id
	@Nonnull
	private String product_id;
	
	/** The product name. */
	@jakarta.validation.constraints.NotBlank(message="this can not be blank")
	private String product_Name;
	
	/** The product quantity. */
	@jakarta.validation.constraints.Min(value=1,message="minimum value should be greater than 1")
	private int product_Quantity;
	
	/** The product description. */
	private String product_description;

	/**
	 * Instantiates a new product.
	 */
	public Product() {

	}

	/**
	 * Instantiates a new product.
	 *
	 * @param product_id the product id
	 * @param product_Name the product name
	 * @param product_Quantity the product quantity
	 * @param product_description the product description
	 */
	public Product(String product_id, String product_Name, int product_Quantity, String product_description) {
		super();
		this.product_id = product_id;
		this.product_Name = product_Name;
		this.product_Quantity = product_Quantity;
		this.product_description = product_description;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProduct_id() {
		return product_id;
	}

	/**
	 * Sets the product id.
	 *
	 * @param product_id the new product id
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProduct_Name() {
		return product_Name;
	}

	/**
	 * Sets the product name.
	 *
	 * @param product_Name the new product name
	 */
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	/**
	 * Gets the product quantity.
	 *
	 * @return the product quantity
	 */
	public int getProduct_Quantity() {
		return product_Quantity;
	}

	/**
	 * Sets the product quantity.
	 *
	 * @param product_Quantity the new product quantity
	 */
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public String getProduct_description() {
		return product_description;
	}

	/**
	 * Sets the product description.
	 *
	 * @param product_description the new product description
	 */
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

}
