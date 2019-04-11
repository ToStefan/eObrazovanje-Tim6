package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.repository.ExamRepository;
import eobrazovanje.tim6.app.service.IExamService;

@Service
public class ExamService implements IExamService {
	
	@Autowired
	private ExamRepository examRepository;

}
