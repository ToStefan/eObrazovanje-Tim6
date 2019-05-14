package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.entity.Student;
import eobrazovanje.tim6.app.repository.StudentRepository;
import eobrazovanje.tim6.app.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRep;

	@Override
	public Student findOne(Long studentId) {
		return studentRep.getOne(studentId);
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		
		return studentRep.findAll(pageable);
	}
	
	
}
