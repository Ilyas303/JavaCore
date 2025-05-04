package ru.innopolis.spring.attestation03.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.innopolis.spring.attestation03.dto.OrderDto;
import ru.innopolis.spring.attestation03.dto.OrderResponseDto;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.model.TyreService;
import ru.innopolis.spring.attestation03.model.User;
import ru.innopolis.spring.attestation03.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @MockitoBean
    private OrderRepository orderRepository;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private TyreServiceService tyreServiceService;

    @Test
    void shouldCreateOrder() {
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(1L);
        orderDto.setServiceId(1L);
        orderDto.setOrderTime(LocalDateTime.now());
        orderDto.setStatus("NEW");

        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        TyreService service = new TyreService();
        service.setId(1L);
        service.setName("Test Service");

        Order order = new Order();
        order.setId(1L);
        order.setUser(user);
        order.setTyreService(service);
        order.setStatus("NEW");

        when(userService.findUserById(1L)).thenReturn(Optional.of(user));
        when(tyreServiceService.findServiceById(1L)).thenReturn(service);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        OrderResponseDto result = orderService.createOrder(orderDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("testuser", result.getUserName());
        assertEquals("Test Service", result.getServiceName());
        assertEquals("NEW", result.getStatus());
    }

    @Test
    void shouldFindAllOrders() {
        User user = new User();
        user.setUsername("testuser");

        TyreService service = new TyreService();
        service.setName("Test Service");

        Order order = new Order();
        order.setId(1L);
        order.setUser(user);
        order.setTyreService(service);
        order.setStatus("NEW");

        when(orderRepository.findAll()).thenReturn(List.of(order));

        List<OrderResponseDto> result = orderService.findAllOrders();

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("testuser", result.get(0).getUserName());
        assertEquals("Test Service", result.get(0).getServiceName());
    }
}