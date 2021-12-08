package com.example.expenses.service;

import com.example.expenses.model.Order;
import com.example.expenses.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock OrderRepository orderRepository;
    @InjectMocks OrderServiceImpl underTest;

    @Test
    void addOrder() {

      Order request = Order.builder().orderName("travel").build();
      Order expected = Order.builder().orderName("food").build();

      when(orderRepository.save(request)).thenReturn(expected);

      Order actual = underTest.addOrder(request);
      verify(orderRepository).save(request );

      assertEquals(expected, actual);

    }
}