package eobrazovanje.tim6.app.service;

import java.util.List;
import eobrazovanje.tim6.app.entity.AcademicRole;

public interface IAcademicRoleService {
	List<AcademicRole> getAll();
	AcademicRole getOne(Long id);
}
