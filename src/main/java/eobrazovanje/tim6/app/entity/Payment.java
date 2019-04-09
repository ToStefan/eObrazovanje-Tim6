
package eobrazovanje.tim6.app.entity;

import java.util.Date;

public class Payment {
	
	private Long id;
	private Integer amount;
	private String paymentPurpose;
	private Date date;
	private Boolean deleted = false;
	private Integer version;
	
	public Student student;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Integer getAmount() {
		
		return amount;
	}
	
	public void setAmount(Integer newAmount) {
		
		amount = newAmount;
	}
	
	public String getPaymentPurpose() {
		
		return paymentPurpose;
	}
	
	public void setPaymentPurpose(String newPaymentPurpose) {
		
		paymentPurpose = newPaymentPurpose;
	}
	
	public Date getDate() {
		
		return date;
	}
	
	public void setDate(Date newDate) {
		
		date = newDate;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean newDeleted) {
		
		deleted = newDeleted;
	}
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer newVersion) {
		
		version = newVersion;
	}
	
	public Student getStudent() {
		
		return student;
	}
	
	public void setStudent(Student newStudent) {
		
		if (this.student == null || !this.student.equals(newStudent)) {
			if (this.student != null) {
				Student oldStudent = this.student;
				this.student = null;
				oldStudent.removePayment(this);
			}
			if (newStudent != null) {
				this.student = newStudent;
				this.student.addPayment(this);
			}
		}
	}
	
}
