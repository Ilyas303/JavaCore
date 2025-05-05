package ru.innopolis.spring.attestation03.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.spring.attestation03.dto.OrderDto;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.service.OrderService;
import ru.innopolis.spring.attestation03.service.TyreServiceService;
import ru.innopolis.spring.attestation03.service.UserService;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final TyreServiceService tyreServiceService;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "orders/list";
    }

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("services", tyreServiceService.findAllServices());
        return "orders/form";
    }

    @PostMapping
    public String createOrder(@ModelAttribute OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return "redirect:/orders";
    }
}