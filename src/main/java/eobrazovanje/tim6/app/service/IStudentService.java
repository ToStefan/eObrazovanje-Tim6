package eobrazovanje.tim6.app.service;

import java.util.List;
import java.util.Set;
import org.springframework.data.domain.PageRequest;
import eobrazovanje.tim6.app.entity.Student;

public interface IStudentService {
	
	List<Student> findAll(PageRequest pageRequest);
	Student findOne(Long studentId);
	
	
	
}
