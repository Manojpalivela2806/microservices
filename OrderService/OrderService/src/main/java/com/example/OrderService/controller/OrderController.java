package com.example.OrderService.controller;

import com.example.OrderService.common.TransactionRequest;
import com.example.OrderService.common.TransactionResponse;
import com.example.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/bookorder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
    {
        return orderService.saveOrder(request);
    }
}
