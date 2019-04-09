package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.StaffRepository;
import eobrazovanje.tim6.app.service.IStaffService;

@Service
public class StaffService implements IStaffService {
	
	@Autowired
	private StaffRepository staffRep;
}
