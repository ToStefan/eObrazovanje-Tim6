package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.AcademicRole;

@JsonInclude(Include.NON_NULL)
public class OldAcademicRoleDTO {
	
	
	private Long id;
	private String name;
	private Long version;
	public Set<OldStaffDTO> staffs = new HashSet<OldStaffDTO>();
	public Set<OldEngagementDTO> engagements = new HashSet<OldEngagementDTO>();
	
	public OldAcademicRoleDTO() {
		
	}
	

	public OldAcademicRoleDTO(Long id, String name, Long version, Set<OldStaffDTO> staffs, Set<OldEngagementDTO> engagements) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.staffs = staffs;
		this.engagements = engagements;
	}
	
	public OldAcademicRoleDTO(AcademicRole academicRole) {
		this(
				academicRole.getId(),
				academicRole.getName(),
				academicRole.getVersion(),
				OldStaffDTO.staffsToStrippedDTOs(academicRole.getStaffs()),
				OldEngagementDTO.engagementsToDTOs(academicRole.getEngagements())
		);
	}
	
	public static List<OldAcademicRoleDTO> academicRolesToDTOs(Collection<AcademicRole> academicRoles) {
		return academicRoles
	            .stream()
	            .map(academicRole -> new OldAcademicRoleDTO(academicRole))
	            .collect(Collectors.toList());
	}
	
	//=========================================================================
	
	public static OldAcademicRoleDTO buildStripped(AcademicRole academicRole) {	
		OldAcademicRoleDTO arDTO = new OldAcademicRoleDTO();
		arDTO.setId(academicRole.getId());
		arDTO.setName(academicRole.getName());
		arDTO.setVersion(academicRole.getVersion());
		return arDTO;
	}
	
	public static Set<OldAcademicRoleDTO> academicRolesToStrippedDTOs(Set<AcademicRole> academicRoles) {
		return academicRoles
	            .stream()
	            .map(academicRole -> buildStripped(academicRole))
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
	public Set<OldStaffDTO> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<OldStaffDTO> staffs) {
		this.staffs = staffs;
	}
	public Set<OldEngagementDTO> getEngagements() {
		return engagements;
	}
	public void setEngagements(Set<OldEngagementDTO> engagements) {
		this.engagements = engagements;
	}
	
	
	
	
	
	
}
