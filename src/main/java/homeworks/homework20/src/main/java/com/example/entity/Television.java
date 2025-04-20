package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "televisions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String manufacturer;

    @Column(columnDefinition = "integer")
    private float screenSize;


    private int resolutionWidth;
    private int resolutionHeight;
    private boolean smartTv;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
}