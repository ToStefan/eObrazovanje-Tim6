package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.PaymentRepository;
import eobrazovanje.tim6.app.service.IPaymentService;

@Service
public class PaymentService implements IPaymentService {
	
	@Autowired
	private PaymentRepository paymentRep;
	
}
