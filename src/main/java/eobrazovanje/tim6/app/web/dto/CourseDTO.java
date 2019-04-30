package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.AcademicRole;
import eobrazovanje.tim6.app.entity.Course;

public class CourseDTO {
	
	
	private Long id;
	private String name;
	private Long version;
	public Set<EngagementDTO> engagements = new HashSet<EngagementDTO>();
	
	public CourseDTO() {
		
	}
	
	
	public CourseDTO(Long id, String name, Long version, Set<EngagementDTO> engagements) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.engagements = engagements;
	}
	
	public CourseDTO(Course course) {
		this(
				course.getId(),
				course.getName(),
				course.getVersion(),
				EngagementDTO.engagementsToDTOs(course.getEngagements())
		);
	}
	
	public static Set<CourseDTO> coursesToDTOs(Set<Course> courses) {
		return courses
	            .stream()
	            .map(course -> new CourseDTO(course))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static CourseDTO buildStripped(Course course) {	
		CourseDTO cDTO = new CourseDTO();
		cDTO.setId(course.getId());
		cDTO.setName(course.getName());
		cDTO.setVersion(course.getVersion());
		return cDTO;
	}
	
	public static Set<CourseDTO> coursesToStrippedDTOs(Set<Course> courses) {
		return courses
	            .stream()
	            .map(course -> buildStripped(course))
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
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Set<EngagementDTO> getEngagements() {
		return engagements;
	}
	public void setEngagements(Set<EngagementDTO> engagements) {
		this.engagements = engagements;
	}
	
	
	
	
	
	

}
