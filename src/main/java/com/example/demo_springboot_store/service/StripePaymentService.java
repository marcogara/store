package com.example.demo_springboot_store.service;

public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("Amount: " + amount);
    }
}
