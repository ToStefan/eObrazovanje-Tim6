package eobrazovanje.tim6.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	public Page<Payment> findByStudentId(Long studentId, Pageable pageable);
	
	public Payment findByIdAndStudentId(Long paymentId, Long studentId);

}
