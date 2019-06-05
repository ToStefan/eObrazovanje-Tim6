package eobrazovanje.tim6.app.service.impl;

import eobrazovanje.tim6.app.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.StaffRepository;
import eobrazovanje.tim6.app.service.IStaffService;

@Service
public class StaffService implements IStaffService {
	
	@Autowired
	private StaffRepository staffRep;

	@Override
	public Staff findOne(Long staffId) {
		return staffRep.getOne(staffId);
	}

	@Override
	public Page<Staff> findAll(Pageable pageable) {
		return staffRep.findAll(pageable);
	}

	@Override
	public Staff save(Staff staff) {
		return staffRep.save(staff);
	}

	@Override
	public Staff update(Staff staff) {
		return staffRep.save(staff);
	}

	public void delete(Long id) {
		staffRep.deleteById(id);
	}




}
