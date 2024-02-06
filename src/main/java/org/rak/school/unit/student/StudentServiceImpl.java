package org.rak.school.unit.student;

import org.rak.school.exception.ApplicationException;
import org.rak.school.interfaces.BusinessService;
import org.rak.school.interfaces.Mapper;
import org.rak.school.interfaces.RequestValidator;
import org.rak.school.unit.grade.GradeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.rak.school.enums.ErrorCodes.ERROR_NOT_FOUND;
import static org.rak.school.enums.ErrorCodes.ERROR_UNABLE_TO_CREATE;
import static org.rak.school.enums.ErrorCodes.ERROR_UNSUPPORTED;

@Service
public class StudentServiceImpl implements BusinessService<StudentDto> {

    private final RequestValidator<StudentDto> validator;
    private final Mapper<StudentDto, Student> mapper;
    private final StudentRepository repository;
    private final GradeServiceImpl gradeService;

    public StudentServiceImpl(RequestValidator<StudentDto> validator, Mapper<StudentDto, Student> mapper, StudentRepository repository
            , GradeServiceImpl gradeService) {
        this.validator = validator;
        this.mapper = mapper;
        this.repository = repository;
        this.gradeService = gradeService;
    }

    @Override
    public StudentDto create(StudentDto dto) {
        return Optional.ofNullable(dto)
                .filter(validator::validateRequest)
                .map(this::prepareStudent)
                .map(repository::save)
                .map(entity -> {
                    StudentDto studentDto = mapper.toDto(entity);
                    studentDto.setGrade(entity.getGrade().getName());
                    return studentDto;
                })
                .orElseThrow(() -> new ApplicationException(ERROR_UNABLE_TO_CREATE));
    }

    @Override
    public StudentDto update(StudentDto dto, String id) {
        return null;
    }

    public StudentDto getByStudentId(String studentId) {
        return repository.findByStudentId(studentId)
                .map((entity) -> {
                    StudentDto studentDto = mapper.toDto(entity);
                    studentDto.setGrade(entity.getGrade().getName());
                    return studentDto;
                })
                .orElseThrow(() -> new ApplicationException(ERROR_NOT_FOUND, "student"));
    }

    @Override
    public void delete(String uuid) {
        throw new ApplicationException(ERROR_UNSUPPORTED);
    }

    private Student prepareStudent(StudentDto studentDto) {
        Student student = mapper.toEntity(studentDto);
        student.setGrade(gradeService.getByName(studentDto.getGrade()));
        return student;
    }
}
