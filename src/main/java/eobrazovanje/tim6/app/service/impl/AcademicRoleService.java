package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.AcademicRoleRepository;
import eobrazovanje.tim6.app.service.IAcademicRoleService;

@Service
public class AcademicRoleService implements IAcademicRoleService {
	
	@Autowired
	private AcademicRoleRepository academicRoleRep;
}
