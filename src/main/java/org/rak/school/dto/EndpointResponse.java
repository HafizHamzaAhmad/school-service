package org.rak.school.dto;

import org.springframework.http.ProblemDetail;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndpointResponse<T> {

	T data;
	ProblemDetail problemDetail;

}
