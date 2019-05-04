package eobrazovanje.tim6.app.web.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.AcademicRole;


public class AcademicRoleDTO {
	
	
	private Long id;
	private String name;
	private Long version;
	public Set<StaffDTO> staffs = new HashSet<StaffDTO>();
	public Set<EngagementDTO> engagements = new HashSet<EngagementDTO>();
	
	public AcademicRoleDTO() {
		
	}
	

	public AcademicRoleDTO(Long id, String name, Long version, Set<StaffDTO> staffs, Set<EngagementDTO> engagements) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.staffs = staffs;
		this.engagements = engagements;
	}
	
	public AcademicRoleDTO(AcademicRole academicRole) {
		this(
				academicRole.getId(),
				academicRole.getName(),
				academicRole.getVersion(),
				StaffDTO.staffsToStrippedDTOs(academicRole.getStaffs()),
				EngagementDTO.engagementsToDTOs(academicRole.getEngagements())
		);
	}
	
	public static List<AcademicRoleDTO> academicRolesToDTOs(Collection<AcademicRole> academicRoles) {
		return academicRoles
	            .stream()
	            .map(academicRole -> new AcademicRoleDTO(academicRole))
	            .collect(Collectors.toList());
	}
	
	//=========================================================================
	
	public static AcademicRoleDTO buildStripped(AcademicRole academicRole) {	
		AcademicRoleDTO arDTO = new AcademicRoleDTO();
		arDTO.setId(academicRole.getId());
		arDTO.setName(academicRole.getName());
		arDTO.setVersion(academicRole.getVersion());
		return arDTO;
	}
	
	public static Set<AcademicRoleDTO> academicRolesToStrippedDTOs(Set<AcademicRole> academicRoles) {
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
	public Set<StaffDTO> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<StaffDTO> staffs) {
		this.staffs = staffs;
	}
	public Set<EngagementDTO> getEngagements() {
		return engagements;
	}
	public void setEngagements(Set<EngagementDTO> engagements) {
		this.engagements = engagements;
	}
	
	
	
	
	
	
}
