package com.example.orderservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreateEvent {
	@TargetAggregateIdentifier
	private final String orderId;
	private final String productId;
	private final int quantity;
	private final String addressId;
	private final String userId;
	private final OrderStatus orderstatus;
}
