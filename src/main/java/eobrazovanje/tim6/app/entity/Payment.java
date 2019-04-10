
package eobrazovanje.tim6.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name = "payment_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "amount", unique = false, nullable = false)
	private Double amount;
	
	@Column(name = "payment_purpose", unique = false, nullable = false)
	private String paymentPurpose;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Integer version;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id")
	public Student student;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Double getAmount() {
		
		return amount;
	}
	
	public void setAmount(Double newAmount) {
		
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
