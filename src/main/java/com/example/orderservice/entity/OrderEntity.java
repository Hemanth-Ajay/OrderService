package com.example.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.orderservice.command.OrderStatus;

import lombok.Data;

@Entity
@Table(name = "OrderTable")
@Data
public class OrderEntity {
	@Id
	@Column(unique = true)
	private  String orderId;
	private  String productId;
	private  int quantity;
	private  String addressId;
	private  String userId;
	private  OrderStatus orderstatus;
	

}
