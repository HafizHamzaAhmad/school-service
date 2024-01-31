package org.rak.school.unit.feerecord;

import org.apache.logging.log4j.util.Strings;
import org.rak.school.annotation.Validator;
import org.rak.school.interfaces.RequestValidator;

import java.util.Optional;

@Validator
public class FeeRecordRequestValidatorImpl implements RequestValidator<FeeRecordDto> {

	private final FeeRecordRepository repository;

	public FeeRecordRequestValidatorImpl(FeeRecordRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateRequest(FeeRecordDto dto) {
		return Optional.ofNullable(dto)
			.filter(dto1 -> Strings.isNotBlank(dto1.getStudentId()))
			.filter(dto1 ->  !repository.existsByStudentIdAndFeeMonthAndFeeYearAndFeeType(dto1.getStudentId(),
					dto1.getFeeMonth(), dto.getFeeYear(), dto.getFeeType()))
			.isPresent();
	}
}
