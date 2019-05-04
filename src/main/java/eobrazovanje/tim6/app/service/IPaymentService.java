package eobrazovanje.tim6.app.service;

import java.util.List;


import eobrazovanje.tim6.app.entity.Payment;

public interface IPaymentService {
	
	List<Payment> findAll();
	Payment findOne(Long paymentId);
	List<Payment> findByStudentId(Long studentId);
	Payment findOneByStudentId(Long paymentId, Long studentId);
	Payment save(Payment payment);
	void remove(Long paymentId);

}
