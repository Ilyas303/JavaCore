package ru.innopolis.spring.attestation03.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long userId;
    private Long serviceId;
    private LocalDateTime orderTime;
    private String status;
}