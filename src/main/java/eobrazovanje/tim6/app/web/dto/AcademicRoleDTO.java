package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;


public class AcademicRoleDTO {

	private Long id;
	private String name;
	private Boolean deleted;
	private Long version;
	private Set<StaffDTO> staffsDTO=new HashSet<>();
	private Set<EngagementDTO> engagementsDTO=new HashSet<>();
	
	public AcademicRoleDTO() {}

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

	public Set<StaffDTO> getStaffsDTO() {
		return staffsDTO;
	}

	public void setStaffsDTO(Set<StaffDTO> staffsDTO) {
		this.staffsDTO = staffsDTO;
	}

	public Set<EngagementDTO> getEngagementsDTO() {
		return engagementsDTO;
	}

	public void setEngagementsDTO(Set<EngagementDTO> engagementsDTO) {
		this.engagementsDTO = engagementsDTO;
	}

	
}
