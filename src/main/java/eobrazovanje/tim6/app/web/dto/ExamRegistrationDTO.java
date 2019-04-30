package eobrazovanje.tim6.app.web.dto;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.AcademicRole;
import eobrazovanje.tim6.app.entity.Engagement;
import eobrazovanje.tim6.app.entity.ExamRegistration;


public class ExamRegistrationDTO {
	
	
	private Long id;
	private Date date;
	private Long version;
	public StudentDTO student;
	public CourseDTO course;
	private TermDTO term;
	
	public ExamRegistrationDTO() {
		
	}
	
	
	public ExamRegistrationDTO(Long id, Date date, Long version, StudentDTO student, CourseDTO course, TermDTO term) {
		super();
		this.id = id;
		this.date = date;
		this.version = version;
		this.student = student;
		this.course = course;
		this.term = term;
	}

	
	public ExamRegistrationDTO(ExamRegistration examRegistration) {
		this(
				examRegistration.getId(),
				examRegistration.getDate(),
				examRegistration.getVersion(),
				StudentDTO.buildStripped(examRegistration.getStudent()),
				CourseDTO.buildStripped(examRegistration.getCourse()),
				new TermDTO(examRegistration.getTerm())
			);
		
	}
	
	public static Set<ExamRegistrationDTO> examRegistrationsToDTOs(Set<ExamRegistration> examRegistrations) {
		return examRegistrations
	            .stream()
	            .map(examRegistration -> new ExamRegistrationDTO(examRegistration))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static ExamRegistrationDTO buildStripped(ExamRegistration examRegistration) {	
		ExamRegistrationDTO erDTO = new ExamRegistrationDTO();
		erDTO.setId(examRegistration.getId());
		erDTO.setDate(examRegistration.getDate());
		erDTO.setVersion(examRegistration.getVersion());
		return erDTO;
	}
	
	public static Set<ExamRegistrationDTO> examRegistrationsToStrippedDTOs(Set<ExamRegistration> examRegistrations) {
		return examRegistrations
	            .stream()
	            .map(examRegistration -> buildStripped(examRegistration))
	            .collect(Collectors.toSet());
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	public TermDTO getTerm() {
		return term;
	}
	public void setTerm(TermDTO term) {
		this.term = term;
	}
	
	
	
	

}
