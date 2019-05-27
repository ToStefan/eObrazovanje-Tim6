package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;

import eobrazovanje.tim6.app.entity.Engagement;
import eobrazovanje.tim6.app.entity.Student;

public class CourseDTO {
	
	private Long id;
	private String name;
	private String year;
	private Boolean deleted;
	private Long version;
	private Set<EngagementDTO> engagementsDTO=new HashSet<>();
	private Set<StudentDTO> studentsDTO=new HashSet<>();
	
	public CourseDTO() {}

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Set<StudentDTO> getStudentsDTO() {
		return studentsDTO;
	}

	public void setStudentsDTO(Set<StudentDTO> studentsDTO) {
		this.studentsDTO = studentsDTO;
	}

	public Set<EngagementDTO> getEngagementsDTO() {
		return engagementsDTO;
	}

	public void setEngagementsDTO(Set<EngagementDTO> engagementsDTO) {
		this.engagementsDTO = engagementsDTO;
	}


	

}
