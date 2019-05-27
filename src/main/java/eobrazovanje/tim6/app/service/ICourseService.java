package eobrazovanje.tim6.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eobrazovanje.tim6.app.entity.Course;
import eobrazovanje.tim6.app.entity.Student;


public interface ICourseService {

	Page<Course> findAll(Pageable pageable);
	Course findOne(Long courseId);
	Course save(Course course);
	Course update(Course course);
	void delete(Long id);
}
