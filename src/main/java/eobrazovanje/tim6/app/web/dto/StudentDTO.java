package eobrazovanje.tim6.app.web.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
			new UserDTO(student.getUser()), //not cyclic - Student -> User -> Roles nesting
			PaymentDTO.paymentsToStrippedDTOs(student.getPayments()),
			DocumentDTO.documentsToStrippedDTOs(student.getDocuments()), 
			PreExamObligationDTO.preExamObligationsToStrippedDTOs(student.getPreExamObligations()), 
			GradeDTO.gradesToStrippedDTOs(student.getGrades()), 
			ExamRegistrationDTO.examRegistrationsToStrippedDTOs(student.getExamRegistrations()),
			CourseDTO.coursesToStrippedDTOs(student.getCourses())
		);
	}
	
	public static List<StudentDTO> studentsToDTOs(Collection<Student> students) {
		return students
	            .stream()
	            .map(student -> new StudentDTO(student))
	            .collect(Collectors.toList());
	}
	
	//=========================================================================
	
	public static StudentDTO buildStripped(Student student) {	
		StudentDTO sDTO = new StudentDTO();
		sDTO.setId(student.getId());
		sDTO.setFirstName(student.getFirstName());
		sDTO.setLastName(student.getLastName());
		sDTO.setIdentificationNumber(student.getIdentificationNumber());
		sDTO.setAccountBalance(student.getAccountBalance());
		sDTO.setAdress(student.getAdress());
		sDTO.setPhoneNumber(student.getPhoneNumber());
		sDTO.setVersion(student.getVersion());
		return sDTO;
	}
	
	public static Set<StudentDTO> strippedStudentsToDTOs(Set<Student> students) {
		return students
	            .stream()
	            .map(student -> buildStripped(student))
	            .collect(Collectors.toSet());
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
