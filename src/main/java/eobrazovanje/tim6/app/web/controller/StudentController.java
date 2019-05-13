package eobrazovanje.tim6.app.web.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import eobrazovanje.tim6.app.entity.Student;
import eobrazovanje.tim6.app.service.impl.StudentService;
import eobrazovanje.tim6.app.web.dto.StudentDTO;
import eobrazovanje.tim6.app.web.mapper.StudentMapper;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		int page = 0; int pageSize = 1;
		//Paging query needs to have a Pageable parameter!
		@SuppressWarnings("deprecation")
		PageRequest pr = new PageRequest(page, pageSize);
		
		List<Student> students = studentService.findAll(pr);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
		return new ResponseEntity<StudentDTO>(studentMapper.toDTO(studentService.findOne(id)), HttpStatus.OK);
		
	}
	
	
	
}
