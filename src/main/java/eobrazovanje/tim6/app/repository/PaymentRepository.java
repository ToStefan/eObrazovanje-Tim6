package eobrazovanje.tim6.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	public List<Payment> findByStudentId(Long studentId);

}
