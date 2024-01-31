package org.rak.school.unit.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class StudentDto {

	@JsonProperty("uuid") private String uuid;
	@NotBlank @JsonProperty("studentName") private String studentName;
	@NotBlank @JsonProperty("studentId") private String studentId;
	@NotBlank @JsonProperty("mobileNumber") private String mobileNumber;
	@NotBlank @JsonProperty("guardian") private String guardian;
	@NotBlank @JsonProperty("schoolName") private String schoolName;
	@NotBlank @JsonProperty("grade") private String grade;
}
