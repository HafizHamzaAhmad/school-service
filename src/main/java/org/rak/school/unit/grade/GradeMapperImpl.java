package org.rak.school.unit.grade;

import org.rak.school.interfaces.Mapper;

import java.util.UUID;

@org.rak.school.annotation.Mapper
public class GradeMapperImpl implements Mapper<GradeDto, Grade> {
	@Override
	public GradeDto toDto(Grade entity) {
		return GradeDto.builder()
	    		.uuid(entity.getUuid())
	    		.name(entity.getName())
	    		.build();
	}

	@Override
	public Grade toEntity(GradeDto dto) {
		return Grade.builder()
	    		.uuid(UUID.randomUUID().toString())
	    		.name(dto.getName())
	    		.build();

	}
}
