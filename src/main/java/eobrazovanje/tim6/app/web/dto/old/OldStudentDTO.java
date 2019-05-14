package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Student;

@JsonInclude(Include.NON_NULL)
public class OldStudentDTO {
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private String identificationNumber;
	private Long accountBalance;
	private String adress;
	private String phoneNumber;
	private Long version;
	public OldUserDTO user;
	public Set<OldPaymentDTO> payments;
	public Set<OldDocumentDTO> documents = new HashSet<OldDocumentDTO>();
	public Set<OldPreExamObligationDTO> preExamObligations = new HashSet<OldPreExamObligationDTO>();
	public Set<OldGradeDTO> grades = new HashSet<OldGradeDTO>();
	public Set<OldExamRegistrationDTO> examRegistrations = new HashSet<OldExamRegistrationDTO>();
	public Set<OldCourseDTO> courses = new HashSet<OldCourseDTO>();
	
	
	public OldStudentDTO() {
		
	}
	
	public OldStudentDTO(Long id, String firstName, String lastName, String identificationNumber, Long accountBalance,
			String adress, String phoneNumber, Long version, OldUserDTO user, Set<OldPaymentDTO> payments,
			Set<OldDocumentDTO> documents, Set<OldPreExamObligationDTO> preExamObligations, Set<OldGradeDTO> grades,
			Set<OldExamRegistrationDTO> examRegistrations, Set<OldCourseDTO> courses) {
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
	
	
	public OldStudentDTO(Student student) {
		this(
			student.getId(), 
			student.getFirstName(), 
			student.getLastName(),
			student.getIdentificationNumber(), 
			student.getAccountBalance(), 
			student.getAdress(),
			student.getPhoneNumber(), 
			student.getVersion(), 
			new OldUserDTO(student.getUser()), //not cyclic - Student -> User -> Roles nesting
			OldPaymentDTO.paymentsToStrippedDTOs(student.getPayments()),
			OldDocumentDTO.documentsToStrippedDTOs(student.getDocuments()), 
			OldPreExamObligationDTO.preExamObligationsToStrippedDTOs(student.getPreExamObligations()), 
			OldGradeDTO.gradesToStrippedDTOs(student.getGrades()), 
			OldExamRegistrationDTO.examRegistrationsToStrippedDTOs(student.getExamRegistrations()),
			OldCourseDTO.coursesToStrippedDTOs(student.getCourses())
		);
	}
	
	public static List<OldStudentDTO> studentsToDTOs(Collection<Student> students) {
		return students
	            .stream()
	            .map(student -> new OldStudentDTO(student))
	            .collect(Collectors.toList());
	}
	
	//=========================================================================
	
	public static OldStudentDTO buildStripped(Student student) {	
		OldStudentDTO sDTO = new OldStudentDTO();
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
	
	public static Set<OldStudentDTO> strippedStudentsToDTOs(Set<Student> students) {
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


	public OldUserDTO getUser() {
		return user;
	}


	public void setUser(OldUserDTO user) {
		this.user = user;
	}


	public Set<OldPaymentDTO> getPayments() {
		return payments;
	}


	public void setPayments(Set<OldPaymentDTO> payments) {
		this.payments = payments;
	}


	public Set<OldDocumentDTO> getDocuments() {
		return documents;
	}


	public void setDocuments(Set<OldDocumentDTO> documents) {
		this.documents = documents;
	}


	public Set<OldPreExamObligationDTO> getPreExamObligations() {
		return preExamObligations;
	}


	public void setPreExamObligations(Set<OldPreExamObligationDTO> preExamObligations) {
		this.preExamObligations = preExamObligations;
	}


	public Set<OldGradeDTO> getGrades() {
		return grades;
	}


	public void setGrades(Set<OldGradeDTO> grades) {
		this.grades = grades;
	}


	public Set<OldExamRegistrationDTO> getExamRegistrations() {
		return examRegistrations;
	}


	public void setExamRegistrations(Set<OldExamRegistrationDTO> examRegistrations) {
		this.examRegistrations = examRegistrations;
	}


	public Set<OldCourseDTO> getCourses() {
		return courses;
	}


	public void setCourses(Set<OldCourseDTO> courses) {
		this.courses = courses;
	}

	
	
	
	
}
