package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.ExamRegistration;

@JsonInclude(Include.NON_NULL)
public class OldExamRegistrationDTO {
	
	
	private Long id;
	private Date date;
	private Long version;
	public OldStudentDTO student;
	public OldCourseDTO course;
	private OldTermDTO term;
	
	public OldExamRegistrationDTO() {
		
	}
	
	
	public OldExamRegistrationDTO(Long id, Date date, Long version, OldStudentDTO student, OldCourseDTO course, OldTermDTO term) {
		super();
		this.id = id;
		this.date = date;
		this.version = version;
		this.student = student;
		this.course = course;
		this.term = term;
	}

	
	public OldExamRegistrationDTO(ExamRegistration examRegistration) {
		this(
				examRegistration.getId(),
				examRegistration.getDate(),
				examRegistration.getVersion(),
				OldStudentDTO.buildStripped(examRegistration.getStudent()),
				OldCourseDTO.buildStripped(examRegistration.getCourse()),
				new OldTermDTO(examRegistration.getTerm())
			);
		
	}
	
	public static Set<OldExamRegistrationDTO> examRegistrationsToDTOs(Collection<ExamRegistration> examRegistrations) {
		return examRegistrations
	            .stream()
	            .map(examRegistration -> new OldExamRegistrationDTO(examRegistration))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static OldExamRegistrationDTO buildStripped(ExamRegistration examRegistration) {	
		OldExamRegistrationDTO erDTO = new OldExamRegistrationDTO();
		erDTO.setId(examRegistration.getId());
		erDTO.setDate(examRegistration.getDate());
		erDTO.setVersion(examRegistration.getVersion());
		return erDTO;
	}
	
	public static Set<OldExamRegistrationDTO> examRegistrationsToStrippedDTOs(Set<ExamRegistration> examRegistrations) {
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
	public OldStudentDTO getStudent() {
		return student;
	}
	public void setStudent(OldStudentDTO student) {
		this.student = student;
	}
	public OldCourseDTO getCourse() {
		return course;
	}
	public void setCourse(OldCourseDTO course) {
		this.course = course;
	}
	public OldTermDTO getTerm() {
		return term;
	}
	public void setTerm(OldTermDTO term) {
		this.term = term;
	}
	
	
	
	

}
