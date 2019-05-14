package eobrazovanje.tim6.app.web.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	
	//pri pozivu proslediti query params {page,size} npr. ?page=1&size=3
	@GetMapping
	public ResponseEntity<Set<StudentDTO>> getStudents(Pageable pageable) {
		Page<Student> students=studentService.findAll(pageable);
		
		Set<StudentDTO> studentsDTO = new HashSet<>();
		for (Student s : students) {
			studentsDTO.add(studentMapper.toDTO(s));
		}
		
		return new ResponseEntity<Set<StudentDTO>>(studentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
		return new ResponseEntity<StudentDTO>(studentMapper.toDTO(studentService.findOne(id)), HttpStatus.OK);
		
	}
	
	
	
}
