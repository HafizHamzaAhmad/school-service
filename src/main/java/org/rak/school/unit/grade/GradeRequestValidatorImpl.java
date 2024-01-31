package org.rak.school.unit.grade;

import org.apache.logging.log4j.util.Strings;
import org.rak.school.annotation.Validator;
import org.rak.school.interfaces.RequestValidator;

import java.util.Optional;

@Validator
public class GradeRequestValidatorImpl implements RequestValidator<GradeDto> {

	private final GradeRepository repository;

	public GradeRequestValidatorImpl(GradeRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateRequest(GradeDto dto) {
		return Optional.ofNullable(dto)
			.filter(dto1 -> Strings.isNotBlank(dto1.getName()))
			.filter(dto1 ->  !repository.existsByName(dto1.getName()))
			.isPresent();
	}
}
