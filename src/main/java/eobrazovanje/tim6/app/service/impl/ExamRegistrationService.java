package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.ExamRegistrationRepository;
import eobrazovanje.tim6.app.service.IExamRegistration;

@Service
public class ExamRegistrationService implements IExamRegistration {
	
	@Autowired
	private ExamRegistrationRepository examRegRepository;
	
	
}
