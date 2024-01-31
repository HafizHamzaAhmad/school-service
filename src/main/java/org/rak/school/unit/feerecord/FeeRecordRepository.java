package org.rak.school.unit.feerecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRecordRepository extends JpaRepository<FeeRecord, Long> {
    List<FeeRecord> findAllByStudentId(String studentId);
    boolean existsByStudentIdAndFeeMonthAndFeeYearAndFeeType(String studentId, String feeMonth, String feeYear, String feeType);
}
