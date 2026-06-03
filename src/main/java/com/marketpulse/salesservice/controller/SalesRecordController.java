package com.marketpulse.salesservice.controller;

import com.marketpulse.salesservice.dto.SalesRequestDto;
import com.marketpulse.salesservice.dto.SalesResponseDto;
import com.marketpulse.salesservice.service.SalesRecordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesRecordController {

    private final SalesRecordService salesRecordService;

    public SalesRecordController(SalesRecordService salesRecordService) {
        this.salesRecordService = salesRecordService;
    }

    @PostMapping
    public ResponseEntity<SalesResponseDto> createSalesRecord(
            @Valid @RequestBody SalesRequestDto dto) {

        SalesResponseDto response =
                salesRecordService.createSalesRecord(dto);

        return ResponseEntity.ok(response);
    }

//    @GetMapping
//    public ResponseEntity<List<SalesResponseDto>> getAllSalesRecords() {
//
//        List<SalesResponseDto> response =
//                salesRecordService.getAllSalesRecords();
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping
    public ResponseEntity<Page<SalesResponseDto>> getAllSalesRecords(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "id") String sortBy,

            @RequestParam(defaultValue = "asc") String direction) {

        return ResponseEntity.ok(
                salesRecordService.getAllSalesRecords(
                        page,
                        size,
                        sortBy,
                        direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesResponseDto> getSalesRecordById(
            @PathVariable Long id) {

        SalesResponseDto response =
                salesRecordService.getSalesRecordById(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesResponseDto> updateSalesRecord(
            @PathVariable Long id,
            @Valid @RequestBody SalesRequestDto dto) {

        SalesResponseDto response =
                salesRecordService.updateSalesRecord(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSalesRecord(
            @PathVariable Long id) {

        salesRecordService.deleteSalesRecord(id);

        return ResponseEntity.ok("Sales Record Deleted Successfully");
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<SalesResponseDto>>
    getSalesByRegion(@PathVariable String region) {

        return ResponseEntity.ok(
                salesRecordService.getSalesByRegion(region));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<SalesResponseDto>>
    getSalesByStatus(@PathVariable String status) {

        return ResponseEntity.ok(
                salesRecordService.getSalesByStatus(status));
    }


    @GetMapping("/search")
    public ResponseEntity<List<SalesResponseDto>>
    searchSales(

            @RequestParam(required = false)
            String region,

            @RequestParam(required = false)
            String status) {

        return ResponseEntity.ok(
                salesRecordService.searchSales(
                        region,
                        status));
    }
}