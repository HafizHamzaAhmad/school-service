package org.rak.school.unit.student;

import org.apache.logging.log4j.util.Strings;
import org.rak.school.annotation.Validator;
import org.rak.school.interfaces.RequestValidator;

import java.util.Optional;

@Validator
public class StudentRequestValidatorImpl implements RequestValidator<StudentDto> {

	private final StudentRepository repository;

	public StudentRequestValidatorImpl(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateRequest(StudentDto dto) {
		return Optional.ofNullable(dto)
			.filter(dto1 -> Strings.isNotBlank(dto1.getStudentId()))
			.filter(dto1 ->  !repository.existsByGrade_NameAndStudentId(dto1.getGrade(), dto1.getStudentId()))
			.isPresent();
	}
}
