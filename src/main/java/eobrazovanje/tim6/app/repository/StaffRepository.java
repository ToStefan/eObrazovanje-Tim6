package eobrazovanje.tim6.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eobrazovanje.tim6.app.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	
	Staff findByUserId(Long userId);
	
}
