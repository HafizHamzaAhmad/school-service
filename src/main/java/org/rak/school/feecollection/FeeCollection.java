package org.rak.school.feecollection;


import org.rak.school.adapter.fee.FeeDto;
import org.rak.school.adapter.fee.FeeManagementServiceAdapter;
import org.rak.school.adapter.transaction.TransactionDto;
import org.rak.school.adapter.transaction.TransactionServiceAdapter;
import org.rak.school.enums.ErrorCodes;
import org.rak.school.exception.ApplicationException;
import org.rak.school.interfaces.Command;
import org.rak.school.unit.feerecord.FeeRecordDto;
import org.rak.school.unit.feerecord.FeeRecordServiceImpl;
import org.rak.school.unit.student.StudentDto;
import org.rak.school.unit.student.StudentServiceImpl;
import org.springframework.stereotype.Service;

import static org.rak.school.constant.Constant.FEE_TYPE_TUITION;
import static org.rak.school.constant.Constant.SCHOOL_LOGO_URL;
import static org.rak.school.constant.Constant.SCHOOL_NAME;

@Service
public class FeeCollection implements Command<FeeCollectionDto> {

    private final FeeManagementServiceAdapter feeManagementServiceAdapter;
    private final StudentServiceImpl studentService;
    private final FeeRecordServiceImpl feeRecordService;
    private final TransactionServiceAdapter transactionService;



    public FeeCollection(FeeManagementServiceAdapter feeManagementServiceAdapter, StudentServiceImpl studentService,
                         FeeRecordServiceImpl feeRecordService, TransactionServiceAdapter transactionService) {
        this.feeManagementServiceAdapter = feeManagementServiceAdapter;
        this.studentService = studentService;
        this.feeRecordService = feeRecordService;
        this.transactionService = transactionService;
    }

    @Override
    public void execute(FeeCollectionDto feeCollectionDto) {
        StudentDto studentDto = studentService.getByStudentId(feeCollectionDto.getStudentId());
        if (studentDto != null) {
            FeeDto fee = getMonthlyTuitionFeeByGrade(studentDto.getGrade());
            if (null != fee && fee.getAmount() != null) {
                performTransaction(feeCollectionDto, studentDto, fee);
                saveFeeRecord(feeCollectionDto);
            } else
                throw new ApplicationException(ErrorCodes.ERROR_UNABLE_TO_PROCESS);
        }
    }

    public FeeDto getMonthlyTuitionFeeByGrade(String grade) {
        return feeManagementServiceAdapter.getFee(FEE_TYPE_TUITION, "GRADE", grade, "MONTHLY");
    }

    public void saveFeeRecord(FeeCollectionDto feeCollectionDto) {
        FeeRecordDto feeRecordDto = FeeRecordDto.builder()
        		.studentId(feeCollectionDto.getStudentId())
        		.feeType(feeCollectionDto.getFeeType())
        		.feeMonth(feeCollectionDto.getMonth())
        		.feeYear(feeCollectionDto.getYear())
        		.status("Paid")
        		.build();
        feeRecordService.createIfNotExist(feeRecordDto);
    }

    public void performTransaction(FeeCollectionDto feeCollectionDto, StudentDto studentDto, FeeDto feeDto){

        TransactionDto transactionDto = TransactionDto.builder()
                .studentName(studentDto.getStudentName())
                .studentId(studentDto.getStudentId())
                .guardianName(studentDto.getGuardian())
                .schoolName(SCHOOL_NAME)
                .amount(feeDto.getAmount())
                .schoolLogoUrl(SCHOOL_LOGO_URL)
                .cardNumber(feeCollectionDto.getCardNumber())
                .cardType(feeCollectionDto.getCardType())
                .grade(studentDto.getGrade())
                .build();

            transactionService.postTransaction(transactionDto).block();
    }
}
