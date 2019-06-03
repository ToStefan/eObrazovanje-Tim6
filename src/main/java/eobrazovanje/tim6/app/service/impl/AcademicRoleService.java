package eobrazovanje.tim6.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.AcademicRole;
import eobrazovanje.tim6.app.repository.AcademicRoleRepository;
import eobrazovanje.tim6.app.service.IAcademicRoleService;

@Service
public class AcademicRoleService implements IAcademicRoleService {
	
	@Autowired
	private AcademicRoleRepository academicRoleRep;

	@Override
	public List<AcademicRole> getAll() {
		return  academicRoleRep.findAll();
	}

	@Override
	public AcademicRole getOne(Long id) {
		
		return academicRoleRep.getOne(id);
	}
}
