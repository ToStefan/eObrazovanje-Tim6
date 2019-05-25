package eobrazovanje.tim6.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Payment;
import eobrazovanje.tim6.app.repository.PaymentRepository;
import eobrazovanje.tim6.app.service.IPaymentService;

@Service
public class PaymentService implements IPaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Page<Payment> findAll(Pageable pageable) {
		return paymentRepository.findAll(pageable);
	}
	
	@Override
	public Payment findOne(Long paymentId) {
		return paymentRepository.getOne(paymentId);
	}
	

	@Override
	public Page<Payment> findByStudentId(Long studentId, Pageable pageable) {
		return paymentRepository.findByStudentId(studentId, pageable);
	}
	
	@Override
	public Payment findOneByStudentId(Long paymentId, Long studentId) {
		return paymentRepository.findByIdAndStudentId(paymentId, studentId);
	}

	@Override
	public Payment save(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Boolean remove(Long paymentId) {
		Payment payment = findOne(paymentId);
		if(payment != null) {
			payment.setDeleted(true);
			save(payment);
			return true;
		}else {
			return false;
		}

	}
	
}
