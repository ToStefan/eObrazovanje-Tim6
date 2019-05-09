package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.PreExamObligation;

@JsonInclude(Include.NON_NULL)
public class OldPreExamObligationDTO {

	private Long id;
	private String name;
	private Integer points;
	private Long version;
	public OldStudentDTO student;
	public OldCourseDTO course;
	
	public OldPreExamObligationDTO() {
		
	}
	
	public OldPreExamObligationDTO(Long id, String name, Integer points, Long version, OldStudentDTO student,
			OldCourseDTO course) {
		super();
		this.id = id;
		this.name = name;
		this.points = points;
		this.version = version;
		this.student = student;
		this.course = course;
	}
	
	public OldPreExamObligationDTO(PreExamObligation preExamObligation) {
		this(
				preExamObligation.getId(),
				preExamObligation.getName(),
				preExamObligation.getPoints(),
				preExamObligation.getVersion(),
				OldStudentDTO.buildStripped(preExamObligation.getStudent()),
				OldCourseDTO.buildStripped(preExamObligation.getCourse())
				
		);
		
	}
	
	public static Set<OldPreExamObligationDTO> preExamObligationsToDTOs(Collection<PreExamObligation> preExamObligations) {
		return preExamObligations
	            .stream()
	            .map(preExamObligation -> new OldPreExamObligationDTO(preExamObligation))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static OldPreExamObligationDTO buildStripped(PreExamObligation preExamObligation) {
		OldPreExamObligationDTO peoDTO = new OldPreExamObligationDTO();
		peoDTO.setId(preExamObligation.getId());
		peoDTO.setName(preExamObligation.getName());
		peoDTO.setPoints(preExamObligation.getPoints());
		peoDTO.setVersion(preExamObligation.getVersion());
		return peoDTO;
	}
		
	public static Set<OldPreExamObligationDTO> preExamObligationsToStrippedDTOs(Set<PreExamObligation> preExamObligations) {
		return preExamObligations
	            .stream()
	            .map(preExamObligation -> buildStripped(preExamObligation))
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
