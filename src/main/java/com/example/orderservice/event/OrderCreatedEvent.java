package com.example.orderservice.event;

import com.example.orderservice.command.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {

	private  String orderId;
	private  String productId;
	private  int quantity;
	private  String addressId;
	private  String userId;
	private  OrderStatus orderstatus;
}
