
package eobrazovanje.tim6.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "payments")
@Where(clause = "deleted=false")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Version
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id")
	public Student student;
	
	public Payment() {
		
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
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		
		this.deleted = deleted;
	}
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer version) {
		
		this.version = version;
	}
	
	public Student getStudent() {
		
		return student;
	}
	
	public void setStudent(Student student) {
		
		this.student = student;
	}
}
