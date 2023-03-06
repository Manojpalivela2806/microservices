package com.example.OrderService.service;

import com.example.OrderService.common.Payment;
import com.example.OrderService.common.TransactionRequest;
import com.example.OrderService.common.TransactionResponse;
import com.example.OrderService.entity.Order;
import com.example.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    public RestTemplate template;
    public TransactionResponse saveOrder(TransactionRequest request)
    {
        String response="";
        Order order = request.getOrder();
        Payment payment= request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse= template. postForObject("http://PAYMENT-SERVICE/payment/dopayment",payment, Payment.class);
        response= paymentResponse.getPaymentStatus().equals("success")?"payment processing successfully and order is placed ":"there is a failure in payment processing,Order is addes to cart";
        orderRepository.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
