package eobrazovanje.tim6.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Student;
import eobrazovanje.tim6.app.repository.StudentRepository;
import eobrazovanje.tim6.app.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRep;

	@Override
	public List<Student> findAll() {
		return studentRep.findAll();
	}

	@Override
	public Student findOne(Long studentId) {
		return studentRep.getOne(studentId);
	}
	
	
}
