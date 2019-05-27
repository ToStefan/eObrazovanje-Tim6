package eobrazovanje.tim6.app.web.controller;

import java.util.List;
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

import eobrazovanje.tim6.app.entity.AcademicRole;
import eobrazovanje.tim6.app.entity.Course;
import eobrazovanje.tim6.app.service.impl.AcademicRoleService;
import eobrazovanje.tim6.app.web.dto.AcademicRoleDTO;
import eobrazovanje.tim6.app.web.dto.CourseDTO;
import eobrazovanje.tim6.app.web.mapper.AcademicRoleMapper;

@RestController
@RequestMapping(value = "api/academic-roles")
public class AcademicRoleController {
	
	@Autowired
	private AcademicRoleService academicRoleService;
	@Autowired
	private AcademicRoleMapper arMapper;
	
	@GetMapping
	public ResponseEntity<Set<AcademicRoleDTO>> getCourses(){
		try {
			List<AcademicRole> ar=academicRoleService.getAll();
			return new ResponseEntity<Set<AcademicRoleDTO>>(arMapper.toDTO(ar),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<AcademicRoleDTO> getCourse(@PathVariable("id") Long id){
		try {
			AcademicRole ar=academicRoleService.getOne(id);
			return new ResponseEntity<AcademicRoleDTO>(arMapper.toDTO(ar),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<AcademicRoleDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
}
