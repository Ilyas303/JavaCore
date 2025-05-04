package ru.innopolis.spring.attestation03.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.spring.attestation03.dto.OrderDto;
import ru.innopolis.spring.attestation03.dto.OrderResponseDto;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.service.OrderService;


import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(OrderApiController.class)
class OrderApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private OrderService orderService;

    @Test
    void getAllOrders_ShouldReturnOrders() throws Exception {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(1L);
        dto.setStatus("NEW");

        when(orderService.findAllOrders()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].status").value("NEW"));
    }

    @Test
    void createOrder_ShouldReturnCreatedOrder() throws Exception {
        OrderDto requestDto = new OrderDto();
        requestDto.setUserId(1L);
        requestDto.setServiceId(1L);
        requestDto.setStatus("NEW");

        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(1L);
        responseDto.setStatus("NEW");

        when(orderService.createOrder(any(OrderDto.class))).thenReturn(responseDto);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.status").value("NEW"));
    }
}