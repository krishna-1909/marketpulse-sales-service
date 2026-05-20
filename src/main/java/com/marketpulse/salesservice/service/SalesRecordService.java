package com.marketpulse.salesservice.service;

import com.marketpulse.salesservice.entity.SalesRecord;
import com.marketpulse.salesservice.repository.SalesRecordRepository;
import org.springframework.stereotype.Service;
import com.marketpulse.salesservice.exception.ResourceNotFoundException;

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
                .orElseThrow(() -> new ResourceNotFoundException("Sales Record Not Found"));
    }



    public SalesRecord updateSalesRecord(Long id, SalesRecord updatedRecord) {

        SalesRecord existingRecord = salesRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sales Record not found"));

        existingRecord.setCustomerName(updatedRecord.getCustomerName());
        existingRecord.setProductName(updatedRecord.getProductName());
        existingRecord.setRegion(updatedRecord.getRegion());
        existingRecord.setSalesAmount(updatedRecord.getSalesAmount());
        existingRecord.setSalesDate(updatedRecord.getSalesDate());
        existingRecord.setStatus(updatedRecord.getStatus());

        return salesRecordRepository.save(existingRecord);
    }

    public void deleteSalesRecord(Long id) {

        SalesRecord existingRecord = salesRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sales Record not found"));

        salesRecordRepository.delete(existingRecord);
    }
}