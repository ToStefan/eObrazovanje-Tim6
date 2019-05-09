package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Course;

@JsonInclude(Include.NON_NULL)
public class OldCourseDTO {
	
	
	private Long id;
	private String name;
	private String year;
	private Long version;
	public Set<OldEngagementDTO> engagements = new HashSet<OldEngagementDTO>();
	
	public OldCourseDTO() {
		
	}
	
	
	public OldCourseDTO(Long id, String name, String year, Long version, Set<OldEngagementDTO> engagements) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.version = version;
		this.engagements = engagements;
	}
	
	public OldCourseDTO(Course course) {
		this(
				course.getId(),
				course.getName(),
				course.getYear(),
				course.getVersion(),
				OldEngagementDTO.engagementsToDTOs(course.getEngagements())
		);
	}
	
	public static Set<OldCourseDTO> coursesToDTOs(Collection<Course> courses) {
		return courses
	            .stream()
	            .map(course -> new OldCourseDTO(course))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static OldCourseDTO buildStripped(Course course) {	
		OldCourseDTO cDTO = new OldCourseDTO();
		cDTO.setId(course.getId());
		cDTO.setName(course.getName());
		cDTO.setVersion(course.getVersion());
		return cDTO;
	}
	
	public static Set<OldCourseDTO> coursesToStrippedDTOs(Set<Course> courses) {
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
	public Set<OldEngagementDTO> getEngagements() {
		return engagements;
	}
	public void setEngagements(Set<OldEngagementDTO> engagements) {
		this.engagements = engagements;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
	
	
	
	
	

}
