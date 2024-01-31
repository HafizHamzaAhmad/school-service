package org.rak.school.fee;

import org.junit.Test;
import org.rak.school.interfaces.Mapper;
import org.rak.school.interfaces.RequestValidator;
import org.rak.school.unit.feerecord.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FeeServiceTest {

    @Test
    public void testCreate() {
        RequestValidator<FeeRecordDto> validator = mock(RequestValidator.class);
        Mapper<FeeRecordDto, FeeRecord> mapper = mock(FeeRecordMapperImpl.class);
        FeeRecordRepository repository = mock(FeeRecordRepository.class);

        FeeRecordServiceImpl yourService = new FeeRecordServiceImpl(validator, mapper, repository);

        FeeRecordDto inputDto = new FeeRecordDto();
        FeeRecord entity = new FeeRecord();
        FeeRecordDto expectedOutputDto = new FeeRecordDto();

        when(validator.validateRequest(inputDto)).thenReturn(true);
        when(mapper.toEntity(inputDto)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(expectedOutputDto);

        FeeRecordDto result = yourService.create(inputDto);

        verify(validator).validateRequest(inputDto);
        verify(mapper).toEntity(inputDto);
        verify(repository).save(entity);
        verify(mapper).toDto(entity);

        assertEquals(expectedOutputDto, result);
    }
    @Test
    public void testFetchFeeRecordsByStudentId() {

        Mapper<FeeRecordDto, FeeRecord> mapper = mock(FeeRecordMapperImpl.class);
        FeeRecordRepository repository = mock(FeeRecordRepository.class);
        RequestValidator<FeeRecordDto> validator = mock(RequestValidator.class);

        FeeRecordServiceImpl yourService = new FeeRecordServiceImpl(validator, mapper, repository);

        String studentId = "123";
        FeeRecord entity1 = new FeeRecord();
        FeeRecord entity2 = new FeeRecord();
        List<FeeRecord> entities = Arrays.asList(entity1, entity2);
        FeeRecordDto expectedDto1 = new FeeRecordDto();
        FeeRecordDto expectedDto2 = new FeeRecordDto();
        List<FeeRecordDto> expectedDtos = Arrays.asList(expectedDto1, expectedDto2);

        when(repository.findAllByStudentId(studentId)).thenReturn(entities);
        when(mapper.toDto(entity1)).thenReturn(expectedDto1);
        when(mapper.toDto(entity2)).thenReturn(expectedDto2);

        List<FeeRecordDto> result = yourService.fetchFeeRecordsByStudentId(studentId);

        verify(repository).findAllByStudentId(studentId);
        verify(mapper).toDto(entity1);
        verify(mapper).toDto(entity2);

        assertEquals(expectedDtos, result);
    }
}
