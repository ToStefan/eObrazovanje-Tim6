package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;

public class StaffDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Boolean deleted;
	private Long version;
	private UserDTO userDTO;
	private AcademicRoleDTO arDTO;
	private Set<EngagementDTO> engagementsDTO=new HashSet<>();
	
	public StaffDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public AcademicRoleDTO getArDTO() {
		return arDTO;
	}

	public void setArDTO(AcademicRoleDTO arDTO) {
		this.arDTO = arDTO;
	}

	public Set<EngagementDTO> getEngagementsDTO() {
		return engagementsDTO;
	}

	public void setEngagementsDTO(Set<EngagementDTO> engagementsDTO) {
		this.engagementsDTO = engagementsDTO;
	}
	
	
}
