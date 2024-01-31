package org.rak.school.feecollection;

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
public class FeeCollectionDto {

	@NotBlank @JsonProperty("studentId") private String studentId;
	@NotBlank @JsonProperty("feeType") private String feeType;
	@NotBlank @JsonProperty("month") private String month;
	@NotBlank @JsonProperty("year") private String year;
	@NotBlank @JsonProperty("paymentType") private String paymentType;
	@NotBlank @JsonProperty("cardNumber") private String cardNumber;
	@NotBlank @JsonProperty("cardType") private String cardType;

}
