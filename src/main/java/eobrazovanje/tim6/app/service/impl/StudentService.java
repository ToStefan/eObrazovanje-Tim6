package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.StudentRepository;
import eobrazovanje.tim6.app.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRep;
}
