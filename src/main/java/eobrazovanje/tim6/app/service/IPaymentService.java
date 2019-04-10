package eobrazovanje.tim6.app.service;

import java.util.List;

import eobrazovanje.tim6.app.entity.Payment;

public interface IPaymentService {
	
	List<Payment> findAll();
	List<Payment> findByStudentId(Long studentId);
	Payment save(Payment payment);
	void remove(Long paymentId);
	

}
