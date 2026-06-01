package com.marketpulse.salesservice.entity;

import jakarta.persistence.*;

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
    private String customerName;

    @Column(name = "product_name")
    private String productName;


    private String region;

    @Column(name = "sales_amount")
    private Double salesAmount;


    @Column(name = "sales_date")
    private LocalDate salesDate;

    private String status;


}