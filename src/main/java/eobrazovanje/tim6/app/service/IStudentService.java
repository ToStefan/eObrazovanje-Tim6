package eobrazovanje.tim6.app.service;

import java.util.List;
import java.util.Set;

import eobrazovanje.tim6.app.entity.Student;

public interface IStudentService {
	
	List<Student> findAll();
	Student findOne(Long studentId);
	
	
	
}
