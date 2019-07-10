package eobrazovanje.tim6.app.service;


import eobrazovanje.tim6.app.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStaffService {

    Staff findOne(Long studentId);
    Staff findByUserId(Long userId);
    Page<Staff> findAll(Pageable pageable);
    Staff save(Staff staff);
    Staff update(Staff staff);
    void delete(Long id);
	
}
