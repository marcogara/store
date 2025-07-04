package com.example.demo_springboot_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringbootStoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoSpringbootStoreApplication.class, args);
		var orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}

}
