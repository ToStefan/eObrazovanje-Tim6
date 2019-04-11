package eobrazovanje.tim6.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.service.impl.CourseService;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
}
