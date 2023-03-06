package com.example.PaymentService.service;

import com.example.PaymentService.entity.Payment;
import com.example.PaymentService.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public Payment doPayment(Payment payment)
    {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }
    public String paymentProcessing()
    {
        return new Random().nextBoolean()?"success":"false";
    }
    public Payment history(int orderId)
    {
        return paymentRepository.findByOrderId(orderId);
    }


}
