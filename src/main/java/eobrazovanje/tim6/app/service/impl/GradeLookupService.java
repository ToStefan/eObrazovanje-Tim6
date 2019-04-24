package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.GradeLookupRepository;
import eobrazovanje.tim6.app.service.IGradeLookupService;

@Service
public class GradeLookupService implements IGradeLookupService {
	
	@Autowired
	private GradeLookupRepository gradeLookupRep;
	
}
