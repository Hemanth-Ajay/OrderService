package com.example.orderservice.saga;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.CommandResultMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.corecommon.commands.ProductReserveCommand;
import com.example.corecommon.event.ProductReservedEvent;
import com.example.orderservice.event.OrderCreatedEvent;

@Saga
public class OrderSaga {

	@Autowired
	private transient CommandGateway commandGateway;
	private static final  Logger LOGGER=LoggerFactory.getLogger(OrderSaga.class);
	

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent createdEvent) {
		ProductReserveCommand reserveProductCommand = ProductReserveCommand.builder()
				.productId(createdEvent.getProductId()).orderId(createdEvent.getOrderId())
				.quantity(createdEvent.getQuantity()).userId(createdEvent.getUserId()).build();
//		commandGateway.sendAndWait(reserveProductCommand, 10, TimeUnit.SECONDS);
		
		commandGateway.send(reserveProductCommand, new CommandCallback<ProductReserveCommand, Object>() {
			@Override
			public void onResult(CommandMessage<? extends ProductReserveCommand> commandMessage,
					CommandResultMessage<? extends Object> commandResultMessage) {
				if (commandResultMessage.isExceptional()) {
					// to handle exceptional
				}

			}
		});
		LOGGER.info("inside order created event "+reserveProductCommand.getOrderId()+" "+reserveProductCommand.getProductId());

	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(ProductReservedEvent reservedEvent) {
		//to handle payment
		LOGGER.info("inside Payment event ");
	}
}
