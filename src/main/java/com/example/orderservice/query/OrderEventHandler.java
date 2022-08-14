package com.example.orderservice.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.event.OrderCreatedEvent;
import com.example.orderservice.repository.OrderRepository;

@Component
@ProcessingGroup("order-group")
public class OrderEventHandler {

	@Autowired
	private OrderRepository orderRepository;

	@EventHandler
	public void on(OrderCreatedEvent createdEvent) {
		OrderEntity entity = new OrderEntity();
		BeanUtils.copyProperties(createdEvent, entity);
		orderRepository.save(entity);

	}

}
