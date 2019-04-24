package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.GradeRepository;
import eobrazovanje.tim6.app.service.IGradeService;

@Service
public class GradeService implements IGradeService {
	
	@Autowired
	private GradeRepository gradeRepository;
	
}
