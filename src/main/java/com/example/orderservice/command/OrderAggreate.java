package com.example.orderservice.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.example.orderservice.event.OrderCreatedEvent;

@Aggregate
public class OrderAggreate {

	@AggregateIdentifier
	private String orderId;
	private String productId;
	private int quantity;
	private String addressId;
	private String userId;
	private OrderStatus orderstatus;

	public OrderAggreate() {

	}

	@CommandHandler
	public  OrderAggreate(OrderCreateEvent orderCreateEvent) throws IllegalArgumentException {
		// validation need to be done
		if(orderCreateEvent.getQuantity()<=0) {
			throw new IllegalArgumentException("Quantity should be greater then zero ");
		}
		if(orderCreateEvent.getUserId().isEmpty() || orderCreateEvent.getUserId()==null ) {
			throw new IllegalArgumentException("Address cannot be empty ");
		}

		OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
		BeanUtils.copyProperties(orderCreateEvent, orderCreatedEvent);
		AggregateLifecycle.apply(orderCreatedEvent);
	}

	@EventSourcingHandler
	public void on(OrderCreatedEvent orderCreatedEvent) {
		this.orderId = orderCreatedEvent.getOrderId();
		this.productId = orderCreatedEvent.getProductId();
		this.quantity = orderCreatedEvent.getQuantity();
		this.addressId = orderCreatedEvent.getAddressId();
		this.userId = orderCreatedEvent.getUserId();
		this.orderstatus = orderCreatedEvent.getOrderstatus();

	}
	
}
