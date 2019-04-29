package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


import eobrazovanje.tim6.app.entity.Staff;

public class StaffDTO {

	private Long id;
	private String firstname;
	private String lastname;
	private Long version;
	public UserDTO user;
	public Set<EngagementDTO> engagements = new HashSet<EngagementDTO>();
	public AcademicRoleDTO academicRole;
	
	public StaffDTO() {
		
	}
	
	

	public StaffDTO(Long id, String firstname, String lastname, Long version, UserDTO user,
			Set<EngagementDTO> engagements, AcademicRoleDTO academicRole) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.version = version;
		this.user = user;
		this.engagements = engagements;
		this.academicRole = academicRole;
	}
	
	public StaffDTO(Staff staff) {
		this(
				staff.getId(),
				staff.getFirstname(),
				staff.getLastname(),
				staff.getVersion(),
				new UserDTO(staff.getUser()),
				EngagementDTO.engagementsToDTOs(staff.getEngagements()),
				new AcademicRoleDTO(staff.getAcademicRole())
		);
	}
	
	public static Set<StaffDTO> staffsToDTOs(Set<Staff> staffs) {
		return staffs
	            .stream()
	            .map(staff -> new StaffDTO(staff))
	            .collect(Collectors.toSet());
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Set<EngagementDTO> getEngagements() {
		return engagements;
	}

	public void setEngagements(Set<EngagementDTO> engagements) {
		this.engagements = engagements;
	}

	public AcademicRoleDTO getAcademicRole() {
		return academicRole;
	}

	public void setAcademicRole(AcademicRoleDTO academicRole) {
		this.academicRole = academicRole;
	}

}
