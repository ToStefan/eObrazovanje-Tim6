package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.AcademicRole;
import eobrazovanje.tim6.app.entity.Grade;

public class GradeDTO {

	private Long id;
	private Integer grade;
	private Integer totalPoints;
	public Set<PreExamObligationDTO> preExamObligations = new HashSet<PreExamObligationDTO>();
	public StudentDTO student;
	public CourseDTO course;
	private Long version;
	
	
	public GradeDTO() {
		
	}
	
	
	public GradeDTO(Long id, Integer grade, Integer totalPoints, Set<PreExamObligationDTO> preExamObligations, StudentDTO student,
			CourseDTO course, Long version) {
		super();
		this.id = id;
		this.grade = grade;
		this.totalPoints = totalPoints;
		this.preExamObligations = preExamObligations;
		this.student = student;
		this.course = course;
		this.version = version;
	}
	
	public GradeDTO(Grade grade) {
		this(
				grade.getId(),
				grade.getGrade(),
				grade.getTotalPoints(),
				PreExamObligationDTO.preExamObligationsToDTOs(grade.getPreExamObligations()),
				new StudentDTO(grade.getStudent()),
				new CourseDTO(grade.getCourse()),
				grade.getVersion()
			);
	}
	
	public static Set<GradeDTO> gradesToDTOs(Set<Grade> grades) {
		return grades
	            .stream()
	            .map(grade -> new GradeDTO(grade))
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

	public Set<PreExamObligationDTO> getPreExamObligations() {
		return preExamObligations;
	}

	public void setPreExamObligations(Set<PreExamObligationDTO> preExamObligations) {
		this.preExamObligations = preExamObligations;
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

}
