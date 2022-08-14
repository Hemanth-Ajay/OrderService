package com.example.orderservice.command.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.command.OrderCreateEvent;
import com.example.orderservice.command.OrderStatus;
import com.example.orderservice.restmodel.RestModel;

@RestController
@RequestMapping("orders")
public class OrderServiceController {

	@Autowired
	private CommandGateway commandGateway;

	@PostMapping
	public String createOrder(@Valid @RequestBody RestModel RestModel) {
		String userId = "27b95829-4f3f-4ddf-8983-151ba010e35b";
		
		OrderCreateEvent orderCreateEvent = OrderCreateEvent.builder().orderId(UUID.randomUUID().toString())
				.productId(RestModel.getProductId()).userId(userId).addressId(RestModel.getAddressId())
				.quantity(RestModel.getQuantity()).orderstatus(OrderStatus.Created).build();

		
			return commandGateway.sendAndWait(orderCreateEvent);
	}

}
