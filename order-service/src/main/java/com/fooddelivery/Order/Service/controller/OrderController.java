package com.fooddelivery.Order.Service.controller;

import com.fooddelivery.Order.Service.dto.OrderRequestDTO;

import com.fooddelivery.Order.Service.dto.OrderResponseDTO;
import com.fooddelivery.Order.Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public OrderResponseDTO placeOrder(@RequestBody OrderRequestDTO request) {
        return orderService.placeOrder(request);
    }

    // GET /orders/health (just a quick check endpoint)
    @GetMapping("/health")
    public String healthCheck() {
        return "Order Service is running 🚀";
    }
}
