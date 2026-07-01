package com.selimhorri.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.selimhorri.app.domain.Cart;
import com.selimhorri.app.domain.Order;
import com.selimhorri.app.dto.OrderDto;
import com.selimhorri.app.exception.wrapper.OrderNotFoundException;
import com.selimhorri.app.helper.OrderMappingHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.selimhorri.app.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void findById_shouldReturnOrderDto_whenOrderExists() {
        Order order = new Order();
        order.setOrderId(1);
        order.setOrderDate(LocalDateTime.now());
        order.setCart(new Cart());

        when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        OrderDto result = orderService.findById(1);
        assertEquals(1, result.getOrderId());
    }

    @Test
    void findById_shouldThrowOrderNotFoundException_whenOrderDoesNotExist() {

        when(orderRepository.findById(999)).thenReturn(Optional.empty());
        assertThrows(OrderNotFoundException.class, () -> orderService.findById(999));


    }
}