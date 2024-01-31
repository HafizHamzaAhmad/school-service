package org.rak.school.fee;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.rak.school.unit.feerecord.FeeRecord;
import org.rak.school.unit.feerecord.FeeRecordRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
public class FeeRepoTest {
    private final FeeRecordRepository feeRecordRepository = createMockFeeRecordRepository() ;
@Before
public void setup() {
    MockitoAnnotations.openMocks(this);
}

    @Test
    public void testFindAllByStudentId() {
        List<FeeRecord> expected = new ArrayList<>();
        expected.add(new FeeRecord(1L, "123456","1","abc", "Paid","2024","PAID"));
        expected.add(new FeeRecord(2L, "123456","1","abc", "Paid","2024","PAID"));
        expected.add(new FeeRecord(3L, "123456","1","abc", "Paid","2024","PAID"));

        when(feeRecordRepository.findAllByStudentId("1")).thenReturn(expected);

        List<FeeRecord> actual = feeRecordRepository.findAllByStudentId("1");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByStudentIdWithNonExistingStudentId() {
        List<FeeRecord> actual = feeRecordRepository.findAllByStudentId("5");
        assertTrue(actual.isEmpty());
    }

    private FeeRecordRepository createMockFeeRecordRepository() {
        FeeRecordRepository feeRecordRepository = mock(FeeRecordRepository.class);
        when(feeRecordRepository.findAllByStudentId(anyString())).thenReturn(new ArrayList<FeeRecord>());
        return feeRecordRepository;
    }

}

