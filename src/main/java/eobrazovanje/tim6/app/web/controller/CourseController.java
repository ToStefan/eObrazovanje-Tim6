package eobrazovanje.tim6.app.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.entity.Course;
import eobrazovanje.tim6.app.service.impl.CourseService;
import eobrazovanje.tim6.app.web.dto.CourseDTO;
import eobrazovanje.tim6.app.web.mapper.CourseMapper;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseMapper courseMapper;
	
	@GetMapping
	public ResponseEntity<Set<CourseDTO>> getCourses(Pageable pageable){
		try {
			Page<Course> courses=courseService.findAll(pageable);
			return new ResponseEntity<Set<CourseDTO>>(courseMapper.toDTO(courses),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") Long courseId){
		try {
			Course cdto=courseService.findOne(courseId);
			return new ResponseEntity<CourseDTO>(courseMapper.toDTO(cdto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO courseDto){
		Course course=courseMapper.toEntity(courseDto);
		try {
			course=courseService.save(course);
			return new ResponseEntity<CourseDTO>(courseMapper.toDTO(course),HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDto){
		Course course=courseMapper.toEntity(courseDto);
		try {
			course.setId(courseDto.getId());
			course=courseService.save(course);
			return new ResponseEntity<CourseDTO>(courseMapper.toDTO(course),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CourseDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id){
		try {
			Course course=courseService.findOne(id);
			course.setDeleted(true);
			courseService.save(course);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
