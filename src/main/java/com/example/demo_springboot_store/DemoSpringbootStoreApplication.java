package com.example.demo_springboot_store;

import com.example.demo_springboot_store.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class DemoSpringbootStoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoSpringbootStoreApplication.class, args);
		var orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}
}
