package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Staff;

@JsonInclude(Include.NON_NULL)
public class OldStaffDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Long version;
	public OldUserDTO user;
	public Set<OldEngagementDTO> engagements = new HashSet<OldEngagementDTO>();
	public OldAcademicRoleDTO academicRole;
	
	public OldStaffDTO() {
		
	}
	
	

	public OldStaffDTO(Long id, String firstName, String lastName, Long version, OldUserDTO user,
			Set<OldEngagementDTO> engagements, OldAcademicRoleDTO academicRole) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.version = version;
		this.user = user;
		this.engagements = engagements;
		this.academicRole = academicRole;
	}
	
	public OldStaffDTO(Staff staff) {
		this(
				staff.getId(),
				staff.getFirstName(),
				staff.getLastName(),
				staff.getVersion(),
				new OldUserDTO(staff.getUser()),
				OldEngagementDTO.engagementsToDTOs(staff.getEngagements()),
				OldAcademicRoleDTO.buildStripped(staff.getAcademicRole())
		);
	}
	
	public static Set<OldStaffDTO> staffsToDTOs(Collection<Staff> staffs) {
		return staffs
	            .stream()
	            .map(staff -> new OldStaffDTO(staff))
	            .collect(Collectors.toSet());
	}
	
	//=========================================================================
	
	public static OldStaffDTO buildStripped(Staff staff) {
		OldStaffDTO sDTO = new OldStaffDTO();
		sDTO.setId(staff.getId());
		sDTO.setFirstName(staff.getFirstName());
		sDTO.setLastName(staff.getLastName());
		sDTO.setVersion(staff.getVersion());
		return sDTO;
	}
		
	public static Set<OldStaffDTO> staffsToStrippedDTOs(Set<Staff> staffs) {
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

	public OldUserDTO getUser() {
		return user;
	}

	public void setUser(OldUserDTO user) {
		this.user = user;
	}

	public Set<OldEngagementDTO> getEngagements() {
		return engagements;
	}

	public void setEngagements(Set<OldEngagementDTO> engagements) {
		this.engagements = engagements;
	}

	public OldAcademicRoleDTO getAcademicRole() {
		return academicRole;
	}

	public void setAcademicRole(OldAcademicRoleDTO academicRole) {
		this.academicRole = academicRole;
	}

}
