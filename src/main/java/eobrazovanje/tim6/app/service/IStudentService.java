package eobrazovanje.tim6.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eobrazovanje.tim6.app.entity.Student;

public interface IStudentService {
	
	
	Student findOne(Long studentId);
	Page<Student> findAll(Pageable pageable);
	
	
	
}
