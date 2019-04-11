
package eobrazovanje.tim6.app.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "students")
@Where(clause = "deleted=false")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name = "student_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "firstname", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "lastname", unique = false, nullable = false)
	private String lastName;
	
	@Column(name = "index", unique = true, nullable = false)
	private String index;
	
	@Column(name = "account_balance", unique = false, nullable = false)
	private Long accountBalance;
	
	@Column(name = "adress", unique = false, nullable = false)
	private String adress;
	
	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@Column(name = "user_id", unique = false, nullable = false)
	public User user;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Collection<Payment> payment;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Document> document = new HashSet<Document>();
	
	@ManyToMany
	@JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
	public Set<Course> course = new HashSet<Course>();;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<ExamRegistration> examRegistration = new HashSet<ExamRegistration>();;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public void setFirstName(String newFirstName) {
		
		firstName = newFirstName;
	}
	
	public String getLastName() {
		
		return lastName;
	}
	
	public void setLastName(String newLastName) {
		
		lastName = newLastName;
	}
	
	public String getIndex() {
		
		return index;
	}
	
	public void setIndex(String newIndex) {
		
		index = newIndex;
	}
	
	public Long getAccountBalance() {
		
		return accountBalance;
	}
	
	public void setAccountBalance(Long newAccountBalance) {
		
		accountBalance = newAccountBalance;
	}
	
	public String getAdress() {
		
		return adress;
	}
	
	public void setAdress(String newAdress) {
		
		adress = newAdress;
	}
	
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		
		phoneNumber = newPhoneNumber;
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
	
	public java.util.Collection<Payment> getPayment() {
		
		if (payment == null)
			payment = new java.util.HashSet<Payment>();
		return payment;
	}
	
	public Iterator getIteratorPayment() {
		
		if (payment == null)
			payment = new java.util.HashSet<Payment>();
		return payment.iterator();
	}
	
	public void setPayment(java.util.Collection<Payment> newPayment) {
		
		removeAllPayment();
		for (Iterator iter = newPayment.iterator(); iter.hasNext();)
			addPayment((Payment) iter.next());
	}
	
	public void addPayment(Payment newPayment) {
		
		if (newPayment == null)
			return;
		if (this.payment == null)
			this.payment = new java.util.HashSet<Payment>();
		if (!this.payment.contains(newPayment)) {
			this.payment.add(newPayment);
			newPayment.setStudent(this);
		}
	}
	
	public void removePayment(Payment oldPayment) {
		
		if (oldPayment == null)
			return;
		if (this.payment != null)
			if (this.payment.contains(oldPayment)) {
				this.payment.remove(oldPayment);
				oldPayment.setStudent((Student) null);
			}
	}
	
	public void removeAllPayment() {
		
		if (payment != null) {
			Payment oldPayment;
			for (Iterator iter = getIteratorPayment(); iter.hasNext();) {
				oldPayment = (Payment) iter.next();
				iter.remove();
				oldPayment.setStudent((Student) null);
			}
		}
	}
	
	public java.util.Set<Document> getDocument() {
		
		if (document == null)
			document = new java.util.HashSet<Document>();
		return document;
	}
	
	public Iterator getIteratorDocument() {
		
		if (document == null)
			document = new java.util.HashSet<Document>();
		return document.iterator();
	}
	
	public void setDocument(java.util.Set<Document> newDocument) {
		
		removeAllDocument();
		for (Iterator iter = newDocument.iterator(); iter.hasNext();)
			addDocument((Document) iter.next());
	}
	
	public void addDocument(Document newDocument) {
		
		if (newDocument == null)
			return;
		if (this.document == null)
			this.document = new java.util.HashSet<Document>();
		if (!this.document.contains(newDocument)) {
			this.document.add(newDocument);
			newDocument.setStudent(this);
		}
	}
	
	public void removeDocument(Document oldDocument) {
		
		if (oldDocument == null)
			return;
		if (this.document != null)
			if (this.document.contains(oldDocument)) {
				this.document.remove(oldDocument);
				oldDocument.setStudent((Student) null);
			}
	}
	
	public void removeAllDocument() {
		
		if (document != null) {
			Document oldDocument;
			for (Iterator iter = getIteratorDocument(); iter.hasNext();) {
				oldDocument = (Document) iter.next();
				iter.remove();
				oldDocument.setStudent((Student) null);
			}
		}
	}
	
	public java.util.Set<Course> getCourse() {
		
		if (course == null)
			course = new java.util.HashSet<Course>();
		return course;
	}
	
	public Iterator getIteratorCourse() {
		
		if (course == null)
			course = new java.util.HashSet<Course>();
		return course.iterator();
	}
	
	public void setCourse(java.util.Set<Course> newCourse) {
		
		removeAllCourse();
		for (Iterator iter = newCourse.iterator(); iter.hasNext();)
			addCourse((Course) iter.next());
	}
	
	public void addCourse(Course newCourse) {
		
		if (newCourse == null)
			return;
		if (this.course == null)
			this.course = new java.util.HashSet<Course>();
		if (!this.course.contains(newCourse))
			this.course.add(newCourse);
	}
	
	public void removeCourse(Course oldCourse) {
		
		if (oldCourse == null)
			return;
		if (this.course != null)
			if (this.course.contains(oldCourse))
				this.course.remove(oldCourse);
	}
	
	public void removeAllCourse() {
		
		if (course != null)
			course.clear();
	}
	
	public java.util.Set<ExamRegistration> getExamRegistration() {
		
		if (examRegistration == null)
			examRegistration = new java.util.HashSet<ExamRegistration>();
		return examRegistration;
	}
	
	public Iterator getIteratorExamRegistration() {
		
		if (examRegistration == null)
			examRegistration = new java.util.HashSet<ExamRegistration>();
		return examRegistration.iterator();
	}
	
	public void setExamRegistration(java.util.Set<ExamRegistration> newExamRegistration) {
		
		removeAllExamRegistration();
		for (java.util.Iterator iter = newExamRegistration.iterator(); iter.hasNext();)
			addExamRegistration((ExamRegistration) iter.next());
	}
	
	public void addExamRegistration(ExamRegistration newExamRegistration) {
		
		if (newExamRegistration == null)
			return;
		if (this.examRegistration == null)
			this.examRegistration = new java.util.HashSet<ExamRegistration>();
		if (!this.examRegistration.contains(newExamRegistration)) {
			this.examRegistration.add(newExamRegistration);
			newExamRegistration.setStudent(this);
		}
	}
	
	public void removeExamRegistration(ExamRegistration oldExamRegistration) {
		
		if (oldExamRegistration == null)
			return;
		if (this.examRegistration != null)
			if (this.examRegistration.contains(oldExamRegistration)) {
				this.examRegistration.remove(oldExamRegistration);
				oldExamRegistration.setStudent((Student) null);
			}
	}
	
	public void removeAllExamRegistration() {
		
		if (examRegistration != null) {
			ExamRegistration oldExamRegistration;
			for (Iterator iter = getIteratorExamRegistration(); iter.hasNext();) {
				oldExamRegistration = (ExamRegistration) iter.next();
				iter.remove();
				oldExamRegistration.setStudent((Student) null);
			}
		}
	}
	
}
