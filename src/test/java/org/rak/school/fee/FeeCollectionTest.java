package org.rak.school.fee;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rak.school.adapter.fee.FeeDto;
import org.rak.school.adapter.fee.FeeManagementServiceAdapter;
import org.rak.school.adapter.transaction.TransactionDto;
import org.rak.school.adapter.transaction.TransactionServiceAdapter;
import org.rak.school.feecollection.FeeCollection;
import org.rak.school.feecollection.FeeCollectionDto;
import org.rak.school.unit.feerecord.FeeRecordServiceImpl;
import org.rak.school.unit.student.StudentDto;
import org.rak.school.unit.student.StudentServiceImpl;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FeeCollectionTest {
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    private FeeManagementServiceAdapter feeManagementServiceAdapter = createFeeManagementServiceAdapter();

    @InjectMocks
    private FeeCollection feeCollection;
    @Mock
    private TransactionServiceAdapter transactionService;

    FeeDto feeDto = createMockFeeDto();

    @Before
    public void setup() {
        feeManagementServiceAdapter = mock(FeeManagementServiceAdapter.class);
        feeDto = new FeeDto();
    }

    @Test
    public void testGetMonthlyTuitionFeeByGrade_Positive() {
        String grade = "A";
        when(feeManagementServiceAdapter.getFee("TUITION", "GRADE", grade, "MONTHLY")).thenReturn(FeeDto.builder().build());
        FeeDto result = feeCollection.getMonthlyTuitionFeeByGrade(grade);

        assertEquals(feeDto, result);
        verify(feeManagementServiceAdapter, times(1)).getFee("TUITION", "GRADE", grade, "MONTHLY");
    }

    @Test
    public void testGetMonthlyTuitionFeeByGrade_Negative() {
        String grade = "Z";
        when(feeManagementServiceAdapter.getFee("TUITION", "GRADE", grade, "MONTHLY")).thenReturn(null);
        FeeDto result = feeCollection.getMonthlyTuitionFeeByGrade(grade);

        assertNull(result);
        verify(feeManagementServiceAdapter, times(1)).getFee("TUITION", "GRADE", grade, "MONTHLY");
    }

    @Test
    public void testPerformTransaction() {
        FeeCollection feeCollection = new FeeCollection(
                mock(FeeManagementServiceAdapter.class),
                mock(StudentServiceImpl.class),
                mock(FeeRecordServiceImpl.class),
                transactionService);

        FeeCollectionDto feeCollectionDto = createMockFeeCollectionDto();
        StudentDto studentDto = createMockStudentDto();
        FeeDto feeDto = createMockFeeDto();

        when(studentDto.getStudentName()).thenReturn("Ali Rehman");
        when(studentDto.getStudentId()).thenReturn("123");
        when(studentDto.getGuardian()).thenReturn("Rehman Asad");
        when(studentDto.getGrade()).thenReturn("A");

        when(feeDto.getAmount()).thenReturn("100.0");
        when(transactionService.postTransaction(any(TransactionDto.class))).thenReturn(Mono.empty());

        feeCollection.performTransaction(feeCollectionDto, studentDto, feeDto);

        verify(transactionService, times(1)).postTransaction(any(TransactionDto.class));
    }

    private FeeCollectionDto createMockFeeCollectionDto() {
        return mock(FeeCollectionDto.class);
    }

    private StudentDto createMockStudentDto() {
        return mock(StudentDto.class);
    }

    private FeeDto createMockFeeDto() {
        return mock(FeeDto.class);
    }

    private FeeManagementServiceAdapter createFeeManagementServiceAdapter(){return  mock(FeeManagementServiceAdapter.class);}
}