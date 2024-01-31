package org.rak.school.unit.student;

import jakarta.persistence.*;

/**
 * @author Usman
 * @created 1/23/2024 - 12:51 AM
 * @project Microservices-assessment
 */
import lombok.*;
import org.rak.school.unit.grade.Grade;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uuid") private String uuid;
	@Column(name = "student_name") private String studentName;
	@Column(name = "student_id") private String studentId;
	@Column(name = "mobile_number") private String mobileNumber;
	@Column(name = "guardian") private String guardian;
	@Column(name = "schoolName") private String schoolName;
	@ManyToOne private Grade grade;

}
