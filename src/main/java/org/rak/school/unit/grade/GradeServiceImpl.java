package org.rak.school.unit.grade;

import org.rak.school.enums.ErrorCodes;
import org.rak.school.exception.ApplicationException;
import org.rak.school.interfaces.BusinessService;
import org.rak.school.interfaces.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeServiceImpl implements BusinessService<GradeDto> {

	private final Mapper<GradeDto, Grade> mapper;
	private final GradeRepository repository;
	private final GradeRequestValidatorImpl validator;

	public GradeServiceImpl(Mapper<GradeDto, Grade> mapper, GradeRepository repository, GradeRequestValidatorImpl validator) {
		this.mapper = mapper;
		this.repository = repository;
		this.validator = validator;
	}


	@Override
	public GradeDto create(GradeDto dto) {
		return Optional.ofNullable(dto)
				.filter(validator::validateRequest)
				.map(mapper::toEntity)
				.map(repository::save)
				.map(mapper::toDto)
				.orElseThrow(() -> new ApplicationException(ErrorCodes.ERROR_UNABLE_TO_CREATE));
	}

	@Override
	public GradeDto update(GradeDto dto, String id) {
		return null;
	}

	@Override
	public void delete(String uuid) {
		throw new ApplicationException(ErrorCodes.ERROR_UNSUPPORTED);
	}

	public Grade getByName(String name) {
		return repository.findByName(name)
				.orElseThrow(() -> new ApplicationException(ErrorCodes.ERROR_NOT_FOUND, "grade"));
	}

	public GradeDto getDtoByName(String name) {
		return mapper.toDto(getByName(name));
	}
}
