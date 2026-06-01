package com.marketpulse.salesservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesResponseDto {

    private Long id;

    private String customerName;

    private String productName;

    private String region;

    private Double salesAmount;

    private LocalDate salesDate;

    private String status;
}