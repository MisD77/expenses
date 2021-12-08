package com.example.expenses.controller;

import com.example.expenses.model.Order;
import com.example.expenses.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderRepositoryControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderService;

    @Test
    void addOrder() {
        Order request = Order.builder().orderName("travel").build();
        Order expected = Order.builder().orderName("food").build();
        when(orderService.addOrder(request)).thenReturn(expected);

        Order actual = orderController.addOrder(request );
        verify(orderService).addOrder(request );

        assertEquals(expected, actual);

    }
}