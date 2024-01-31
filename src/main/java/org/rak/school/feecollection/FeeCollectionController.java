package org.rak.school.feecollection;

import org.rak.school.dto.EndpointResponse;
import org.rak.school.interfaces.Command;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class FeeCollectionController {

	private Command<FeeCollectionDto> feeCollection;

	public FeeCollectionController(FeeCollection feeCollection) {
		this.feeCollection = feeCollection;
	}


	@PostMapping("/collect-fee")
	EndpointResponse<Void> getFeeRecordByStudentId(@RequestBody FeeCollectionDto feeCollectionDto){
		feeCollection.execute(feeCollectionDto);
		return new EndpointResponse<>(null,null);
	}

}
