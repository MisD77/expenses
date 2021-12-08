package com.example.expenses.service;

import com.example.expenses.model.Order;
import com.example.expenses.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order)
    {
        return orderRepository.save(order);
    }
}
