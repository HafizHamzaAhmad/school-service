package org.rak.school.unit.feerecord;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class FeeRecordDto {

	@JsonProperty("uuid") private String uuid;
	@NotBlank @JsonProperty("student_id") private String studentId;
	@NotBlank @JsonProperty("fee_type") private String feeType;
	@NotBlank @JsonProperty("feeMonth") private String feeMonth;
	@NotBlank @JsonProperty("feeYear") private String feeYear;
	@NotBlank @JsonProperty("status") private String status;

}
