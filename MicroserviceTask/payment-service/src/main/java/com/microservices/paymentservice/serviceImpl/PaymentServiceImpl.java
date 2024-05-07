package com.microservices.paymentservice.serviceImpl;

import com.microservices.paymentservice.entity.Payment;
import com.microservices.paymentservice.repository.PaymentRepository;
import com.microservices.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
       return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayment() {
       return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).get();
    }
}
