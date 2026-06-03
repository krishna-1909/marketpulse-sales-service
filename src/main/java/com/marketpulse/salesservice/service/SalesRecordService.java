package com.marketpulse.salesservice.service;

import com.marketpulse.salesservice.dto.SalesRequestDto;
import com.marketpulse.salesservice.dto.SalesResponseDto;
import com.marketpulse.salesservice.entity.SalesRecord;
import com.marketpulse.salesservice.exception.ResourceNotFoundException;
import com.marketpulse.salesservice.mapper.SalesRecordMapper;
import com.marketpulse.salesservice.repository.SalesRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class SalesRecordService {

    private final SalesRecordRepository salesRecordRepository;

    public SalesRecordService(SalesRecordRepository salesRecordRepository) {
        this.salesRecordRepository = salesRecordRepository;
    }

    public SalesResponseDto createSalesRecord(SalesRequestDto dto) {

        SalesRecord salesRecord = SalesRecordMapper.toEntity(dto);

        SalesRecord savedRecord = salesRecordRepository.save(salesRecord);

        return SalesRecordMapper.toDto(savedRecord);
    }

//    public List<SalesResponseDto> getAllSalesRecords() {
//
//        return salesRecordRepository.findAll()
//                .stream()
//                .map(SalesRecordMapper::toDto)
//                .toList();
//    }

    // pagination + sorting  for get all
    public Page<SalesResponseDto> getAllSalesRecords(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable =
                PageRequest.of(page, size, sort);

        Page<SalesRecord> salesPage =
                salesRecordRepository.findAll(pageable);

        return salesPage.map(SalesRecordMapper::toDto);
    }

    // crud operations below except getall
    public SalesResponseDto getSalesRecordById(Long id) {

        SalesRecord salesRecord = salesRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sales Record Not Found"));

        return SalesRecordMapper.toDto(salesRecord);
    }

    public SalesResponseDto updateSalesRecord(Long id,
                                              SalesRequestDto dto) {

        SalesRecord existingRecord = salesRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sales Record Not Found"));

        existingRecord.setCustomerName(dto.getCustomerName());
        existingRecord.setProductName(dto.getProductName());
        existingRecord.setRegion(dto.getRegion());
        existingRecord.setSalesAmount(dto.getSalesAmount());
        existingRecord.setSalesDate(dto.getSalesDate());
        existingRecord.setStatus(dto.getStatus());

        SalesRecord updatedRecord =
                salesRecordRepository.save(existingRecord);

        return SalesRecordMapper.toDto(updatedRecord);
    }

    public void deleteSalesRecord(Long id) {

        SalesRecord existingRecord = salesRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sales Record Not Found"));

        salesRecordRepository.delete(existingRecord);
    }

    public List<SalesResponseDto> getSalesByRegion(String region) {

        List<SalesRecord> salesRecords =
                salesRecordRepository.findByRegion(region);

        return salesRecords.stream()
                .map(SalesRecordMapper::toDto)
                .toList();
    }

    public List<SalesResponseDto> getSalesByStatus(String status) {

        List<SalesRecord> salesRecords =
                salesRecordRepository.findByStatus(status);

        return salesRecords.stream()
                .map(SalesRecordMapper::toDto)
                .toList();
    }


    // search?region=Texas&status=COMPLETED
    public List<SalesResponseDto> searchSales(
            String region,
            String status) {

        List<SalesRecord> salesRecords;

        if (region != null && status != null) {

            salesRecords =
                    salesRecordRepository
                            .findByRegionAndStatus(
                                    region,
                                    status);

        } else if (region != null) {

            salesRecords =
                    salesRecordRepository
                            .findByRegion(region);

        } else if (status != null) {

            salesRecords =
                    salesRecordRepository
                            .findByStatus(status);

        } else {

            salesRecords =
                    salesRecordRepository.findAll();
        }

        return salesRecords.stream()
                .map(SalesRecordMapper::toDto)
                .toList();
    }


}