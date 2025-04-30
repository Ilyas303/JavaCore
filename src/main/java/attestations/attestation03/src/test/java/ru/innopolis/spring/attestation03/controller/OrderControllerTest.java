package ru.innopolis.spring.attestation03.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.model.TyreService;
import ru.innopolis.spring.attestation03.model.User;
import ru.innopolis.spring.attestation03.service.OrderService;
import ru.innopolis.spring.attestation03.service.TyreServiceService;
import ru.innopolis.spring.attestation03.service.UserService;


import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private TyreServiceService tyreServiceService;

    @Test
    void listOrders_ShouldReturnOrdersView() throws Exception {
        Order order = new Order();
        order.setId(1L);

        when(orderService.findAllOrders()).thenReturn(List.of(order));

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(view().name("orders/list"))
                .andExpect(model().attributeExists("orders"));
    }

    @Test
    void showOrderForm_ShouldReturnFormView() throws Exception {
        User user = new User();
        user.setId(1L);
        TyreService service = new TyreService();
        service.setId(1L);

        when(userService.findAllUsers()).thenReturn(List.of(user));
        when(tyreServiceService.findAllServices()).thenReturn(List.of(service));

        mockMvc.perform(get("/orders/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("orders/form"))
                .andExpect(model().attributeExists("order"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attributeExists("services"));
    }

    @Test
    void createOrder_ShouldRedirectToList() throws Exception {
        Order order = new Order();
        order.setId(1L);

        when(orderService.createOrder(any(Order.class))).thenReturn(order);

        mockMvc.perform(post("/orders")
                        .param("status", "NEW"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/orders"));
    }
}