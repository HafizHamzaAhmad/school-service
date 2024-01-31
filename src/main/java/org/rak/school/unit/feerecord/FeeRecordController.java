package org.rak.school.unit.feerecord;

import org.rak.school.dto.EndpointResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/fee-record")
public class FeeRecordController {

	private final FeeRecordServiceImpl feeRecordService;

	public FeeRecordController(FeeRecordServiceImpl feeRecordService) {
		this.feeRecordService = feeRecordService;
	}


	@GetMapping("/studentId/{studentId}")
	EndpointResponse<List<FeeRecordDto>> getFeeRecordByStudentId(@PathVariable String studentId){
		return new EndpointResponse<>(feeRecordService.fetchFeeRecordsByStudentId(studentId),null);
	}

}
