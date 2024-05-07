package com.microservices.paymentservice.service;

import com.microservices.paymentservice.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    public Payment createPayment(Payment payment);

    public List<Payment> getAllPayment();

    public Payment getPaymentById(int id);
}
