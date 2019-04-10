package eobrazovanje.tim6.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Payment;
import eobrazovanje.tim6.app.repository.PaymentRepository;
import eobrazovanje.tim6.app.service.IPaymentService;

@Service
public class PaymentService implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public List<Payment> findByStudentId(Long studentId) {
		return paymentRepository.findByStudentId(studentId);
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public void remove(Long paymentId) {
		paymentRepository.deleteById(paymentId);
		
	}

}
