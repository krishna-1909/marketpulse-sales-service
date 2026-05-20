package com.marketpulse.salesservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "sales_records")
@Data
public class SalesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Column(name = "product_name")
    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Region is required")
    private String region;

    @NotNull(message = "Sales amount is required")
    @Positive(message = "Sales amount must be positive")
    @Column(name = "sales_amount")
    private Double salesAmount;

    @NotNull(message = "Sales date is required")
    @Column(name = "sales_date")
    private LocalDate salesDate;

    @NotBlank(message = "Status is required")
    private String status;


}