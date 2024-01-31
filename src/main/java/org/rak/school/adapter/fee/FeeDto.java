package org.rak.school.adapter.fee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class FeeDto implements Serializable {

	@JsonProperty("uuid") private String uuid;
	@NotBlank @JsonProperty("description") private String description;
	@NotBlank @JsonProperty("type") private String type;
	@NotBlank @JsonProperty("subCategory") private String subCategory;
	@NotBlank @JsonProperty("frequency") private String frequency;
	@NotBlank @JsonProperty("category") private String category;
	@NotBlank @JsonProperty("amount") private String amount;
}
