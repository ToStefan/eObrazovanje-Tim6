package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Payment;
import eobrazovanje.tim6.app.web.dto.PaymentDTO;

@Component
public class PaymentMapper implements Mapper<Payment, PaymentDTO> {
	
	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public PaymentDTO toDTO(Payment payment) {
		PaymentDTO pDTO = new PaymentDTO();
		pDTO.setId(payment.getId());
		pDTO.setAmount(payment.getAmount());
		pDTO.setPaymentPurpose(payment.getPaymentPurpose());
		pDTO.setDate(payment.getDate());
		pDTO.setDeleted(payment.getDeleted());
		pDTO.setVersion(payment.getVersion());
		pDTO.setStudent(studentMapper.toStrippedDTO(payment.getStudent()));
		return pDTO;
	}
	
	@Override
	public Set<PaymentDTO> toDTO(Collection<Payment> entities) {
		return entities
				.stream()
				.map(payment -> toDTO(payment))
				.collect(Collectors.toSet());
	}
	
	public PaymentDTO toStrippedDTO(Payment payment) {
		PaymentDTO pDTO = new PaymentDTO();
		pDTO.setId(payment.getId());
		pDTO.setAmount(payment.getAmount());
		pDTO.setPaymentPurpose(payment.getPaymentPurpose());
		pDTO.setDate(payment.getDate());
		pDTO.setDeleted(payment.getDeleted());
		pDTO.setVersion(payment.getVersion());
		return pDTO;
	}
	
	public Set<PaymentDTO> toStrippedDTO(Collection<Payment> payments){
		return payments
			.stream()
			.map(payment -> toStrippedDTO(payment))
			.collect(Collectors.toSet());
	}

	@Override
	public Payment toEntity(PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		payment.setAmount(paymentDTO.getAmount());
		payment.setPaymentPurpose(paymentDTO.getPaymentPurpose());
		payment.setDate(paymentDTO.getDate());
		payment.setDeleted(paymentDTO.getDeleted());
		payment.setVersion(paymentDTO.getVersion());
		
		return payment;
	}

	
	@Override
	public Set<Payment> toEntity(Collection<PaymentDTO> dtos) {
		return dtos
				.stream()
				.map(dto -> toEntity(dto))
				.collect(Collectors.toSet());
	}
	
	public Payment toExistingEntity(Payment payment, PaymentDTO paymentDTO) {
		payment.setAmount(paymentDTO.getAmount());
		payment.setPaymentPurpose(paymentDTO.getPaymentPurpose());
		payment.setDate(paymentDTO.getDate());
		payment.setDeleted(paymentDTO.getDeleted());
		payment.setVersion(paymentDTO.getVersion());
		return payment;
	}

}
