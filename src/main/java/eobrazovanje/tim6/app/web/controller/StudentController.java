package eobrazovanje.tim6.app.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.service.impl.StudentService;
import eobrazovanje.tim6.app.web.dto.StudentDTO;
import eobrazovanje.tim6.app.web.dto.old.OldStudentDTO;
import eobrazovanje.tim6.app.web.mapper.StudentMapper;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@GetMapping
	public ResponseEntity<Set<StudentDTO>> getStudents() {
		return new ResponseEntity<Set<StudentDTO>>(studentMapper.toDTO(studentService.findAll()), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id){
		return new ResponseEntity<StudentDTO>(studentMapper.toDTO(studentService.findOne(id)), HttpStatus.OK);
		
	}
	
	
	
}
