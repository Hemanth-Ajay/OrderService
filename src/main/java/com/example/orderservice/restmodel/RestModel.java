package com.example.orderservice.restmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data

public class RestModel {

	@NotBlank(message = "Products cannot be empty")
	private String productId;
	@Min(value = 1, message = "Orders Min 1")
	private int quantity;
	@NotBlank(message = "Address cannot be empty")
	private String addressId;
}
