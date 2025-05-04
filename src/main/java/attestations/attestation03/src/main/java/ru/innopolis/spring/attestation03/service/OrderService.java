package ru.innopolis.spring.attestation03.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.spring.attestation03.dto.OrderDto;
import ru.innopolis.spring.attestation03.dto.OrderResponseDto;
import ru.innopolis.spring.attestation03.mapper.OrderMapper;
import ru.innopolis.spring.attestation03.model.Order;
import ru.innopolis.spring.attestation03.model.TyreService;
import ru.innopolis.spring.attestation03.model.User;
import ru.innopolis.spring.attestation03.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final TyreServiceService tyreServiceService;
    private final OrderMapper orderMapper;

    public List<OrderResponseDto> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toResponseDto)
                .toList();
    }

    public Optional<OrderResponseDto> findOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toResponseDto);
    }

    public List<OrderResponseDto> findUserOrders(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(orderMapper::toResponseDto)
                .toList();
    }

    public OrderResponseDto createOrder(OrderDto orderDto) {
        User user = userService.findUserById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        TyreService service = tyreServiceService.findServiceById(orderDto.getServiceId());
        if (service == null) {
            throw new RuntimeException("Служба не найдена");
        }

        Order order = orderMapper.toEntity(orderDto, user, service);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponseDto(savedOrder);
    }

    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}