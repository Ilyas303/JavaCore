package ru.innopolis.spring.attestation03.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Long id;
    private String userName;
    private String serviceName;
    private LocalDateTime orderTime;
    private String status;
}