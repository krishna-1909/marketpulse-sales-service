package com.marketpulse.salesservice.controller;

import com.marketpulse.salesservice.entity.SalesRecord;
import com.marketpulse.salesservice.service.SalesRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sales")
public class SalesRecordController {

    private final SalesRecordService salesRecordService;

    public SalesRecordController(SalesRecordService salesRecordService) {
        this.salesRecordService = salesRecordService;
    }

    @PostMapping
    public ResponseEntity<SalesRecord> createSalesRecord(@Valid @RequestBody SalesRecord salesRecord) {

        SalesRecord savedRecord = salesRecordService.createSalesRecord(salesRecord);

        return ResponseEntity.ok(savedRecord);
    }

    @GetMapping
    public ResponseEntity<List<SalesRecord>> getAllSalesRecords() {

        List<SalesRecord> salesRecords = salesRecordService.getAllSalesRecords();

        return ResponseEntity.ok(salesRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesRecord> getSalesRecordById(@PathVariable Long id) {

        SalesRecord salesRecord = salesRecordService.getSalesRecordById(id);

        return ResponseEntity.ok(salesRecord);
    }

    @PutMapping("/{id}")
    public SalesRecord updateSalesRecord(@Valid @PathVariable Long id,
                                         @RequestBody SalesRecord salesRecord) {

        return salesRecordService.updateSalesRecord(id, salesRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalesRecord(@PathVariable Long id) {

        salesRecordService.deleteSalesRecord(id);

        return ResponseEntity.ok("Sales Record Deleted Successfully");
    }

}