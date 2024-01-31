package org.rak.school.unit.grade;

import org.rak.school.dto.EndpointResponse;
import org.rak.school.interfaces.BusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/grade")
public class GradeController {

	private final BusinessService<GradeDto> businessService;
	private final GradeServiceImpl gradeService;

	public GradeController(BusinessService<GradeDto> businessService, GradeServiceImpl gradeService) {
		this.businessService = businessService;
		this.gradeService = gradeService;
	}


	@GetMapping("/name/{name}")
	EndpointResponse<GradeDto> getGradeByName(@PathVariable String name){
		return new EndpointResponse<>(gradeService.getDtoByName(name),null);
	}

	@PostMapping
	EndpointResponse<GradeDto> createGrade(@RequestBody GradeDto gradeDto){
		return new EndpointResponse<>(businessService.create(gradeDto), null);
	}

}
