package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Engagement;

@JsonInclude(Include.NON_NULL)
public class OldEngagementDTO {

	private Long id;
	private Long version;
	public OldAcademicRoleDTO academicRole;
	public OldCourseDTO course;
	public OldStaffDTO staff;
	
	public OldEngagementDTO() {
		
	}
	

	public OldEngagementDTO(Long id, Long version, OldAcademicRoleDTO academicRole, OldCourseDTO course, OldStaffDTO staff) {
		super();
		this.id = id;
		this.version = version;
		this.academicRole = academicRole;
		this.course = course;
		this.staff = staff;
	}
	
	public OldEngagementDTO(Engagement engagement) {
		this(
				engagement.getId(),
				engagement.getVersion(),
				OldAcademicRoleDTO.buildStripped(engagement.getAcademicRole()),
				OldCourseDTO.buildStripped(engagement.getCourse()),
				OldStaffDTO.buildStripped(engagement.getStaff())
				
		);
	}
	
	public static Set<OldEngagementDTO> engagementsToDTOs(Collection<Engagement> engagements) {
		return engagements
	            .stream()
	            .map(engagement -> new OldEngagementDTO(engagement))
	            .collect(Collectors.toSet());
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public OldAcademicRoleDTO getAcademicRole() {
		return academicRole;
	}

	public void setAcademicRole(OldAcademicRoleDTO academicRole) {
		this.academicRole = academicRole;
	}

	public OldCourseDTO getCourse() {
		return course;
	}

	public void setCourse(OldCourseDTO course) {
		this.course = course;
	}

	public OldStaffDTO getStaff() {
		return staff;
	}

	public void setStaff(OldStaffDTO staff) {
		this.staff = staff;
	}

}
