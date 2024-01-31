package org.rak.school.adapter.transaction;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.rak.school.adapter.fee.FeeDto;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class FeeResponseDto implements Serializable {

    @JsonProperty("data")
    private FeeDto data;

    @JsonProperty("problemDetail")
    private String problemDetail;

}