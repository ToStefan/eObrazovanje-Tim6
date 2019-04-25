
package eobrazovanje.tim6.app.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "students")
@Where(clause = "deleted=false")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "first_name", unique = false, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", unique = false, nullable = false)
	private String lastName;
	
	@Column(name = "id_number", unique = true, nullable = false)
	private String identificationNumber;
	
	@Column(name = "account_balance", unique = false, nullable = false)
	private Long accountBalance;
	
	@Column(name = "adress", unique = false, nullable = false)
	private String adress;
	
	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Version
	@Column(name = "version", unique = false, nullable = false)
	private Long version;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id", nullable = false)
	public User user;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Collection<Payment> payments;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Document> documents = new HashSet<Document>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<PreExamObligation> exams = new HashSet<PreExamObligation>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Grade> grades = new HashSet<Grade>();
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<ExamRegistration> examRegistrations = new HashSet<ExamRegistration>();
	
	@ManyToMany
	@JoinTable(name = "student_courses", 
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"), 
					inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
	public Set<Course> courses = new HashSet<Course>();
	
	public Student() {
		
	}
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	public String getLastName() {
		
		return lastName;
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	public String getIndex() {
		
		return identificationNumber;
	}
	
	public void setIndex(String identificationNumber) {
		
		this.identificationNumber = identificationNumber;
	}
	
	public Long getAccountBalance() {
		
		return accountBalance;
	}
	
	public void setAccountBalance(Long accountBalance) {
		
		this.accountBalance = accountBalance;
	}
	
	public String getAdress() {
		
		return adress;
	}
	
	public void setAdress(String adress) {
		
		this.adress = adress;
	}
	
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		
		this.phoneNumber = phoneNumber;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		
		this.deleted = deleted;
	}
	
	public Long getVersion() {
		
		return version;
	}
	
	public void setVersion(Long version) {
		
		this.version = version;
	}
	
	public User getUser() {
		
		return user;
	}
	
	public void setUser(User user) {
		
		this.user = user;
	}
	
	public Collection<Payment> getPayments() {
		
		return payments;
	}
	
	public void setPayments(Collection<Payment> payments) {
		
		this.payments = payments;
	}
	
	public Set<Document> getDocuments() {
		
		return documents;
	}
	
	public void setDocuments(Set<Document> documents) {
		
		this.documents = documents;
	}
	
	public Set<PreExamObligation> getExams() {
		
		return exams;
	}
	
	public void setExams(Set<PreExamObligation> exams) {
		
		this.exams = exams;
	}
	
	public Set<Grade> getGrades() {
		
		return grades;
	}
	
	public void setGrades(Set<Grade> grades) {
		
		this.grades = grades;
	}
	
	public Set<Course> getCourses() {
		
		return courses;
	}
	
	public void setCourses(Set<Course> courses) {
		
		this.courses = courses;
	}
	
	public Set<ExamRegistration> getExamRegistrations() {
		
		return examRegistrations;
	}
	
	public void setExamRegistrations(Set<ExamRegistration> examRegistrations) {
		
		this.examRegistrations = examRegistrations;
	}
}
