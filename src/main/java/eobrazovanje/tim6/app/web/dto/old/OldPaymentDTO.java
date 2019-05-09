package eobrazovanje.tim6.app.web.dto.old;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Payment;

@JsonInclude(Include.NON_NULL)
public class OldPaymentDTO implements Serializable {

	private Long id;
	private Double amount;
	private String paymentPurpose;
	private Date date;
	private Long version;
	public OldStudentDTO student;
	
	public OldPaymentDTO() {
		
	}
	
	
	public OldPaymentDTO(Long id, Double amount, String paymentPurpose, Date date, Long version, OldStudentDTO student) {
		super();
		this.id = id;
		this.amount = amount;
		this.paymentPurpose = paymentPurpose;
		this.date = date;
		this.version = version;
		this.student = student;
	}
	
	public OldPaymentDTO(Payment payment) {
		this(
				payment.getId(), 
				payment.getAmount(), 
				payment.getPaymentPurpose(), 
				payment.getDate(), 
				payment.getVersion(), 
				OldStudentDTO.buildStripped(payment.getStudent())
			);
	}
	
	
	
	public static Set<OldPaymentDTO> paymentsToDTOs(Collection<Payment> payments) {
		return payments
	            .stream()
	            .map(payment -> new OldPaymentDTO(payment))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static OldPaymentDTO buildStripped(Payment payment) {
		OldPaymentDTO pDTO = new OldPaymentDTO();
		pDTO.setId(payment.getId());
		pDTO.setAmount(payment.getAmount());
		pDTO.setPaymentPurpose(payment.getPaymentPurpose());
		pDTO.setDate(payment.getDate());
		pDTO.setVersion(payment.getVersion());
		return pDTO;
	}
		
	public static Set<OldPaymentDTO> paymentsToStrippedDTOs(Set<Payment> payments) {
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

	public OldStudentDTO getStudent() {
		return student;
	}

	public void setStudent(OldStudentDTO student) {
		this.student = student;
	}

}
