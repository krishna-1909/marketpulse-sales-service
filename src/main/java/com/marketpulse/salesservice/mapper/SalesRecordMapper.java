package com.marketpulse.salesservice.mapper;

import com.marketpulse.salesservice.dto.SalesRequestDto;
import com.marketpulse.salesservice.dto.SalesResponseDto;
import com.marketpulse.salesservice.entity.SalesRecord;

public class SalesRecordMapper {

    public static SalesRecord toEntity(SalesRequestDto dto) {

        SalesRecord salesRecord = new SalesRecord();

        salesRecord.setCustomerName(dto.getCustomerName());
        salesRecord.setProductName(dto.getProductName());
        salesRecord.setRegion(dto.getRegion());
        salesRecord.setSalesAmount(dto.getSalesAmount());
        salesRecord.setSalesDate(dto.getSalesDate());
        salesRecord.setStatus(dto.getStatus());

        return salesRecord;
    }

    public static SalesResponseDto toDto(SalesRecord salesRecord) {

        SalesResponseDto dto = new SalesResponseDto();

        dto.setId(salesRecord.getId());
        dto.setCustomerName(salesRecord.getCustomerName());
        dto.setProductName(salesRecord.getProductName());
        dto.setRegion(salesRecord.getRegion());
        dto.setSalesAmount(salesRecord.getSalesAmount());
        dto.setSalesDate(salesRecord.getSalesDate());
        dto.setStatus(salesRecord.getStatus());

        return dto;
    }
}