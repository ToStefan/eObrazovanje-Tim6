package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.EngagementRepository;
import eobrazovanje.tim6.app.service.IEngagementService;

@Service
public class EngagementService implements IEngagementService {
	
	@Autowired
	private EngagementRepository engagementRep;
}
