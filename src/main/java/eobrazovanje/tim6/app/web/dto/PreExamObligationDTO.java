package eobrazovanje.tim6.app.web.dto;

import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.Engagement;
import eobrazovanje.tim6.app.entity.PreExamObligation;

public class PreExamObligationDTO {

	private Long id;
	private String name;
	private Integer points;
	private Long version;
	public StudentDTO student;
	public CourseDTO course;
	
	public PreExamObligationDTO() {
		
	}
	
	public PreExamObligationDTO(Long id, String name, Integer points, Long version, StudentDTO student,
			CourseDTO course) {
		super();
		this.id = id;
		this.name = name;
		this.points = points;
		this.version = version;
		this.student = student;
		this.course = course;
	}
	
	public PreExamObligationDTO(PreExamObligation preExamObligation) {
		this(
				preExamObligation.getId(),
				preExamObligation.getName(),
				preExamObligation.getPoints(),
				preExamObligation.getVersion(),
				new StudentDTO(preExamObligation.getStudent()),
				new CourseDTO(preExamObligation.getCourse())
				
		);
		
	}
	
	public static Set<PreExamObligationDTO> preExamObligationsToDTOs(Set<PreExamObligation> preExamObligations) {
		return preExamObligations
	            .stream()
	            .map(preExamObligation -> new PreExamObligationDTO(preExamObligation))
	            .collect(Collectors.toSet());
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
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

}
