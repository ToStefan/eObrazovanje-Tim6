package eobrazovanje.tim6.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.service.impl.CourseService;
import eobrazovanje.tim6.app.web.dto.CourseDTO;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public ResponseEntity<List<CourseDTO>> getCourses(){
		return null;
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<CourseDTO> getCourse(){
		return null;
	}
	
}
