package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;

import eobrazovanje.tim6.app.entity.Student;

public class StudentDTO {
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private String identificationNumber;
	private Long accountBalance;
	private String adress;
	private String phoneNumber;
	private Long version;
	public UserDTO user;
	public Set<PaymentDTO> payments;
	public Set<DocumentDTO> documents = new HashSet<DocumentDTO>();
	public Set<PreExamObligationDTO> preExamObligations = new HashSet<PreExamObligationDTO>();
	public Set<GradeDTO> grades = new HashSet<GradeDTO>();
	public Set<ExamRegistrationDTO> examRegistrations = new HashSet<ExamRegistrationDTO>();
	public Set<CourseDTO> courses = new HashSet<CourseDTO>();
	
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(Long id, String firstName, String lastName, String identificationNumber, Long accountBalance,
			String adress, String phoneNumber, Long version, UserDTO user, Set<PaymentDTO> payments,
			Set<DocumentDTO> documents, Set<PreExamObligationDTO> preExamObligations, Set<GradeDTO> grades,
			Set<ExamRegistrationDTO> examRegistrations, Set<CourseDTO> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
		this.accountBalance = accountBalance;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.version = version;
		this.user = user;
		this.payments = payments;
		this.documents = documents;
		this.preExamObligations = preExamObligations;
		this.grades = grades;
		this.examRegistrations = examRegistrations;
		this.courses = courses;
	}
	
	public StudentDTO(Student student) {
		this(
			student.getId(), 
			student.getFirstName(), 
			student.getLastName(),
			student.getIdentificationNumber(), 
			student.getAccountBalance(), 
			student.getAdress(),
			student.getPhoneNumber(), 
			student.getVersion(), 
			new UserDTO(student.getUser()), 
			PaymentDTO.paymentsToDTOs(student.getPayments()), 
			DocumentDTO.documentsToDTOs(student.getDocuments()), 
			PreExamObligationDTO.preExamObligationsToDTOs(student.getPreExamObligations()), 
			GradeDTO.gradesToDTOs(student.getGrades()), 
			ExamRegistrationDTO.examRegistrationsToDTOs(student.getExamRegistrations()),
			CourseDTO.coursesToDTOs(student.getCourses())
		);
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

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public Set<PaymentDTO> getPayments() {
		return payments;
	}


	public void setPayments(Set<PaymentDTO> payments) {
		this.payments = payments;
	}


	public Set<DocumentDTO> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<DocumentDTO> documents) {
		this.documents = documents;
	}


	public Set<PreExamObligationDTO> getPreExamObligations() {
		return preExamObligations;
	}


	public void setPreExamObligations(Set<PreExamObligationDTO> preExamObligations) {
		this.preExamObligations = preExamObligations;
	}


	public Set<GradeDTO> getGrades() {
		return grades;
	}


	public void setGrades(Set<GradeDTO> grades) {
		this.grades = grades;
	}


	public Set<ExamRegistrationDTO> getExamRegistrations() {
		return examRegistrations;
	}


	public void setExamRegistrations(Set<ExamRegistrationDTO> examRegistrations) {
		this.examRegistrations = examRegistrations;
	}


	public Set<CourseDTO> getCourses() {
		return courses;
	}


	public void setCourses(Set<CourseDTO> courses) {
		this.courses = courses;
	}

	
	
	
	
}
