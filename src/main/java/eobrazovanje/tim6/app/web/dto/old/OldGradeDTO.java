package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Grade;

@JsonInclude(Include.NON_NULL)
public class OldGradeDTO {

	private Long id;
	private Integer grade;
	private Integer totalPoints;
	public Set<OldPreExamObligationDTO> preExamObligations = new HashSet<OldPreExamObligationDTO>();
	public OldStudentDTO student;
	public OldCourseDTO course;
	private Long version;
	
	
	public OldGradeDTO() {
		
	}
	
	
	public OldGradeDTO(Long id, Integer grade, Integer totalPoints, Set<OldPreExamObligationDTO> preExamObligations, OldStudentDTO student,
			OldCourseDTO course, Long version) {
		super();
		this.id = id;
		this.grade = grade;
		this.totalPoints = totalPoints;
		this.preExamObligations = preExamObligations;
		this.student = student;
		this.course = course;
		this.version = version;
	}
	
	public OldGradeDTO(Grade grade) {
		this(
				grade.getId(),
				grade.getGrade(),
				grade.getTotalPoints(),
				OldPreExamObligationDTO.preExamObligationsToDTOs(grade.getPreExamObligations()),
				OldStudentDTO.buildStripped(grade.getStudent()),
				new OldCourseDTO(grade.getCourse()),
				grade.getVersion()
			);
	}
	
	public static Set<OldGradeDTO> gradesToDTOs(Collection<Grade> grades) {
		return grades
	            .stream()
	            .map(grade -> new OldGradeDTO(grade))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static OldGradeDTO buildStripped(Grade grade) {	
		OldGradeDTO gDTO = new OldGradeDTO();
		gDTO.setId(grade.getId());
		gDTO.setGrade(grade.getGrade());
		gDTO.setTotalPoints(grade.getTotalPoints());
		return gDTO;
	}
	
	public static Set<OldGradeDTO> gradesToStrippedDTOs(Set<Grade> grades) {
		return grades
	            .stream()
	            .map(grade -> buildStripped(grade))
	            .collect(Collectors.toSet());
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Set<OldPreExamObligationDTO> getPreExamObligations() {
		return preExamObligations;
	}

	public void setPreExamObligations(Set<OldPreExamObligationDTO> preExamObligations) {
		this.preExamObligations = preExamObligations;
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

}
