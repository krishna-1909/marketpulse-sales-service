package com.marketpulse.salesservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesRequestDto {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Region is required")
    private String region;

    @NotNull(message = "Sales amount is required")
    @Positive(message = "Sales amount must be positive")
    private Double salesAmount;

    @NotNull(message = "Sales date is required")
    private LocalDate salesDate;

    @NotBlank(message = "Status is required")
    private String status;

    // getters and setters
}