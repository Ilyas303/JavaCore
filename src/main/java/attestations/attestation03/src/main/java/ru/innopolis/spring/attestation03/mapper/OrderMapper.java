package ru.innopolis.spring.attestation03.mapper;

import org.springframework.stereotype.Component;
import ru.innopolis.spring.attestation03.dto.OrderDto;
import ru.innopolis.spring.attestation03.dto.OrderResponseDto;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.model.TyreService;
import ru.innopolis.spring.attestation03.model.User;

@Component
public class OrderMapper {
    public OrderResponseDto toResponseDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setUserName(order.getUser().getUsername());
        dto.setServiceName(order.getTyreService().getName());
        dto.setOrderTime(order.getOrderTime());
        dto.setStatus(order.getStatus());
        return dto;
    }

    public Order toEntity(OrderDto orderDto, User user, TyreService service) {
        Order order = new Order();
        order.setUser(user);
        order.setTyreService(service);
        order.setOrderTime(orderDto.getOrderTime());
        order.setStatus(orderDto.getStatus());
        return order;
    }
}