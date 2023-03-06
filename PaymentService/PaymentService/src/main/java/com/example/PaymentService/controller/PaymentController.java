package com.example.PaymentService.controller;

import com.example.PaymentService.entity.Payment;
import com.example.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("dopayment")
    public Payment doPayment(@RequestBody Payment payment)
    {
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findHistoryById(@PathVariable int orderId)
    {
        return paymentService.history(orderId);
    }
}
