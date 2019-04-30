package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.PreExamObligation;
import eobrazovanje.tim6.app.entity.Staff;

public class StaffDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Long version;
	public UserDTO user;
	public Set<EngagementDTO> engagements = new HashSet<EngagementDTO>();
	public AcademicRoleDTO academicRole;
	
	public StaffDTO() {
		
	}
	
	

	public StaffDTO(Long id, String firstName, String lastName, Long version, UserDTO user,
			Set<EngagementDTO> engagements, AcademicRoleDTO academicRole) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.user = user;
		this.engagements = engagements;
		this.academicRole = academicRole;
	}
	
	public StaffDTO(Staff staff) {
		this(
				staff.getId(),
				staff.getFirstName(),
				staff.getLastName(),
				staff.getVersion(),
				new UserDTO(staff.getUser()),
				EngagementDTO.engagementsToDTOs(staff.getEngagements()),
				AcademicRoleDTO.buildStripped(staff.getAcademicRole())
		);
	}
	
	public static Set<StaffDTO> staffsToDTOs(Set<Staff> staffs) {
		return staffs
	            .stream()
	            .map(staff -> new StaffDTO(staff))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static StaffDTO buildStripped(Staff staff) {
		StaffDTO sDTO = new StaffDTO();
		sDTO.setId(staff.getId());
		sDTO.setFirstName(staff.getFirstName());
		sDTO.setLastName(staff.getLastName());
		sDTO.setVersion(staff.getVersion());
		return sDTO;
	}
		
	public static Set<StaffDTO> staffsToStrippedDTOs(Set<Staff> staffs) {
		return staffs
	            .stream()
	            .map(staff -> buildStripped(staff))
	            .collect(Collectors.toSet());
	}



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
