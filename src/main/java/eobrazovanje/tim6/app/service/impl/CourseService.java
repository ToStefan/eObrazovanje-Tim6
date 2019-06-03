package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Course;
import eobrazovanje.tim6.app.repository.CourseRepository;
import eobrazovanje.tim6.app.service.ICourseService;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Page<Course> findAll(Pageable pageable) {
		
		return courseRepository.findAll(pageable);
	}

	@Override
	public Course findOne(Long courseId) {
		
		return courseRepository.getOne(courseId);
	}

	@Override
	public Course save(Course course) {
		
		return courseRepository.save(course);
	}

	@Override
	public Course update(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void delete(Long id) {
		courseRepository.deleteById(id);
		
	}

}
