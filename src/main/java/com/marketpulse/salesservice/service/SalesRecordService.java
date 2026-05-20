package com.marketpulse.salesservice.service;

import com.marketpulse.salesservice.entity.SalesRecord;
import com.marketpulse.salesservice.repository.SalesRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesRecordService {

    private final SalesRecordRepository salesRecordRepository;

    public SalesRecordService(SalesRecordRepository salesRecordRepository) {
        this.salesRecordRepository = salesRecordRepository;
    }

    public SalesRecord createSalesRecord(SalesRecord salesRecord) {
        return salesRecordRepository.save(salesRecord);
    }

    public List<SalesRecord> getAllSalesRecords() {
        return salesRecordRepository.findAll();
    }

    public SalesRecord getSalesRecordById(Long id) {

        return salesRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sales Record Not Found"));
    }
}