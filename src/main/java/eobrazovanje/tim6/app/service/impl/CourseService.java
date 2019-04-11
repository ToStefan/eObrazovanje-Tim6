package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.repository.CourseRepository;
import eobrazovanje.tim6.app.service.ICourseService;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepository;

}
