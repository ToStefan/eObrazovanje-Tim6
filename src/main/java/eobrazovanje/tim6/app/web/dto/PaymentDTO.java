package eobrazovanje.tim6.app.web.dto;

import java.util.Date;



public class PaymentDTO {
	
	private Long id;
	private Double amount;
	private String paymentPurpose;
	private Date date;
	private Long version;
	private Boolean deleted;
	private StudentDTO student;
	
	public PaymentDTO() {
		
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
	

}
