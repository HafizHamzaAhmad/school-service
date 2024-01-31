package org.rak.school.unit.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Boolean existsByGrade_NameAndStudentId(String grade, String studentId);

	Optional<Student> findByStudentId(String studentId);
}
