package org.rak.school.unit.feerecord;

import org.rak.school.exception.ApplicationException;
import org.rak.school.interfaces.BusinessService;
import org.rak.school.interfaces.Mapper;
import org.rak.school.interfaces.RequestValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.rak.school.enums.ErrorCodes.ERROR_ALREADY_EXISTS;
import static org.rak.school.enums.ErrorCodes.ERROR_UNABLE_TO_CREATE;
import static org.rak.school.enums.ErrorCodes.ERROR_UNSUPPORTED;

@Service
public class FeeRecordServiceImpl implements BusinessService<FeeRecordDto> {

	private final RequestValidator<FeeRecordDto> validator;
	private final Mapper<FeeRecordDto, FeeRecord> mapper;
	private final FeeRecordRepository repository;

	public FeeRecordServiceImpl(RequestValidator<FeeRecordDto> validator, Mapper<FeeRecordDto, FeeRecord> mapper, FeeRecordRepository repository) {
		this.validator = validator;
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public FeeRecordDto create(FeeRecordDto dto) {
		return Optional.ofNullable(dto)
			.filter(validator::validateRequest)
			.map(mapper::toEntity)
			.map(repository::save)
			.map(mapper::toDto)
			.orElseThrow(() -> new ApplicationException(ERROR_UNABLE_TO_CREATE));
	}

	@Override
	public FeeRecordDto update(FeeRecordDto dto, String id) {
		return null;
	}

	@Override
	public void delete(String uuid) {
		throw new ApplicationException(ERROR_UNSUPPORTED);
	}

	public List<FeeRecordDto> fetchFeeRecordsByStudentId(String studentId) {
		return repository.findAllByStudentId(studentId).stream().map(mapper::toDto).toList();

	}

	public void createIfNotExist(FeeRecordDto dto) {
		if(repository.existsByStudentIdAndFeeMonthAndFeeYearAndFeeType(dto.getStudentId(),
				dto.getFeeMonth(), dto.getFeeYear(), dto.getFeeType()))
			throw new ApplicationException(ERROR_ALREADY_EXISTS, "Fee record");
		repository.save(mapper.toEntity(dto));
	}

}
