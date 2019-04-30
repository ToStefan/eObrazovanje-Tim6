package eobrazovanje.tim6.app.web.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import eobrazovanje.tim6.app.entity.Grade;
import eobrazovanje.tim6.app.entity.Payment;

public class PaymentDTO implements Serializable {

	private Long id;
	private Double amount;
	private String paymentPurpose;
	private Date date;
	private Long version;
	public StudentDTO student;
	
	public PaymentDTO() {
		
	}
	
	
	public PaymentDTO(Long id, Double amount, String paymentPurpose, Date date, Long version, StudentDTO student) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentPurpose = paymentPurpose;
		this.date = date;
		this.version = version;
		this.student = student;
	}
	
	public PaymentDTO(Payment payment) {
		this(
				payment.getId(), 
				payment.getAmount(), 
				payment.getPaymentPurpose(), 
				payment.getDate(), 
				payment.getVersion(), 
				StudentDTO.buildStripped(payment.getStudent())
			);
	}
	
	
	
	public static Set<PaymentDTO> paymentsToDTOs(Set<Payment> payments) {
		return payments
	            .stream()
	            .map(payment -> new PaymentDTO(payment))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static PaymentDTO buildStripped(Payment payment) {
		PaymentDTO pDTO = new PaymentDTO();
		pDTO.setId(payment.getId());
		pDTO.setAmount(payment.getAmount());
		pDTO.setPaymentPurpose(payment.getPaymentPurpose());
		pDTO.setDate(payment.getDate());
		pDTO.setVersion(payment.getVersion());
		return pDTO;
	}
		
	public static Set<PaymentDTO> paymentsToStrippedDTOs(Set<Payment> payments) {
		return payments
	            .stream()
	            .map(payment -> buildStripped(payment))
	            .collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentPurpose() {
		return paymentPurpose;
	}

	public void setPaymentPurpose(String paymentPurpose) {
		this.paymentPurpose = paymentPurpose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

}
