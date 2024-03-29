package org.rak.school.unit.student;

import org.rak.school.dto.EndpointResponse;
import org.rak.school.interfaces.BusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	private final BusinessService<StudentDto> businessService;
	private final StudentServiceImpl studentService;

	public StudentController(BusinessService<StudentDto> businessService, StudentServiceImpl studentService) {
		this.businessService = businessService;
		this.studentService = studentService;
	}


	@GetMapping("/studentId/{studentId}")
	EndpointResponse<StudentDto> getStudentById(@PathVariable String studentId){
		return new EndpointResponse<>(studentService.getByStudentId(studentId),null);
	}

	@PostMapping
	EndpointResponse<StudentDto> createStudent(@RequestBody StudentDto studentDto){
		return new EndpointResponse<>(businessService.create(studentDto), null);
	}

}
