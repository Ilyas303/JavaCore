package ru.innopolis.spring.attestation03.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.repository.OrderRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldCreateOrder() {
        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order created = orderService.createOrder(order);
        assertNotNull(created);
        verify(orderRepository).save(order);
    }

    @Test
    void shouldFindUserOrders() {
        List<Order> orders = List.of(new Order(), new Order());
        when(orderRepository.findByUserId(1L)).thenReturn(orders);

        List<Order> result = orderService.findUserOrders(1L);
        assertEquals(2, result.size());
    }
}