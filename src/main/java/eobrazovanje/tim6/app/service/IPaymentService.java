package eobrazovanje.tim6.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eobrazovanje.tim6.app.entity.Payment;

public interface IPaymentService {
	
	Page<Payment> findAll(Pageable pageable);
	Payment findOne(Long paymentId);
	Page<Payment> findByStudentId(Long studentId, Pageable pageable);
	Payment findOneByStudentId(Long paymentId, Long studentId);
	Payment save(Payment payment);
	Boolean remove(Long paymentId);

}
