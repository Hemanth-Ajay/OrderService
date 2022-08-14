package com.example.orderservice.restmodel;

import com.example.orderservice.command.OrderStatus;

import lombok.Value;

@Value
public class OrderSummary {
	private final String orderId;
	private final OrderStatus orderStatus;
	private final String message;

}
