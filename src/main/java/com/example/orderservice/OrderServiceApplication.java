package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.example.corecommon.configuration.AxonConfig;
import com.example.orderservice.configuration.AxonConfigOrder;

@SpringBootApplication
@EnableDiscoveryClient
//@Import({ AxonConfig.class })
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	


}
