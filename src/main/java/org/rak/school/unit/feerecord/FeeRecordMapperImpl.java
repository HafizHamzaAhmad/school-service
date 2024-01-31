package org.rak.school.unit.feerecord;

import org.rak.school.interfaces.Mapper;

@org.rak.school.annotation.Mapper
public class FeeRecordMapperImpl implements Mapper<FeeRecordDto, FeeRecord> {
	@Override
	public FeeRecordDto toDto(FeeRecord entity) {
		return FeeRecordDto.builder()
	    		.uuid(entity.getUuid())
	    		.studentId(entity.getStudentId())
	    		.feeType(entity.getFeeType())
	    		.feeMonth(entity.getFeeMonth())
	    		.feeYear(entity.getFeeYear())
	    		.status(entity.getStatus())
	    		.build();

	}

	@Override
	public FeeRecord toEntity(FeeRecordDto dto) {
	    return FeeRecord.builder()
	    		.uuid(dto.getUuid())
	    		.studentId(dto.getStudentId())
	    		.feeType(dto.getFeeType())
	    		.feeMonth(dto.getFeeMonth())
	    		.feeYear(dto.getFeeYear())
	    		.status(dto.getStatus())
	    		.build();

	}
}
