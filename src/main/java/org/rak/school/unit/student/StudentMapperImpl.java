package org.rak.school.unit.student;

import org.rak.school.interfaces.Mapper;

import java.util.UUID;

@org.rak.school.annotation.Mapper
public class StudentMapperImpl implements Mapper<StudentDto, Student> {
	@Override
	public StudentDto toDto(Student entity) {
		return StudentDto.builder()
	    		.uuid(entity.getUuid())
	    		.studentName(entity.getStudentName())
				.studentId(entity.getStudentId())
				.mobileNumber(entity.getMobileNumber())
				.guardian(entity.getGuardian())
				.schoolName(entity.getSchoolName())
	    		.build();

	}

	@Override
	public Student toEntity(StudentDto dto) {
		return Student.builder()
	    		.uuid(UUID.randomUUID().toString())
	    		.studentName(dto.getStudentName())
				.mobileNumber(dto.getMobileNumber())
				.studentId(dto.getStudentId())
				.guardian(dto.getGuardian())
				.schoolName(dto.getSchoolName())
	    		.build();

	}
}
