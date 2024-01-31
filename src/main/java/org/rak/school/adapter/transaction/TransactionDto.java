package org.rak.school.adapter.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class TransactionDto implements Serializable {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("studentName")
    private String studentName;

    @JsonProperty("studentId")
    private String studentId;

    @JsonProperty("guardianName")
    private String guardianName;

    @JsonProperty("schoolName")
    private String schoolName;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("schoolLogoUrl")
    private String schoolLogoUrl;

    @JsonProperty("cardNumber")
    @Pattern(regexp= "^(5[1-5]\\d{14})$", message="Invalid card number!")
    private String cardNumber;

    @JsonProperty("cardType")
    private String cardType;


    @JsonProperty("grade")
    private String grade;

}