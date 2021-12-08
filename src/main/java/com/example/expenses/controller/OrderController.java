package com.example.expenses.controller;

import com.example.expenses.model.Order;
import com.example.expenses.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public Order addOrder(Order order)
    {
        return orderService.addOrder(order);
    }


}
