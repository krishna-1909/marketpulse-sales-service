package com.marketpulse.salesservice.repository;

import com.marketpulse.salesservice.entity.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> {

    List<SalesRecord> findByRegion(String region);

    List<SalesRecord> findByStatus(String status);
}
