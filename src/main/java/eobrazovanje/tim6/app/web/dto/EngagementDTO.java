package eobrazovanje.tim6.app.web.dto;

import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.Engagement;
import eobrazovanje.tim6.app.entity.Payment;

public class EngagementDTO {

	private Long id;
	private Long version;
	public AcademicRoleDTO academicRole;
	public CourseDTO course;
	public StaffDTO staff;
	
	public EngagementDTO() {
		
	}
	

	public EngagementDTO(Long id, Long version, AcademicRoleDTO academicRole, CourseDTO course, StaffDTO staff) {
		super();
		this.id = id;
		this.version = version;
		this.academicRole = academicRole;
		this.course = course;
		this.staff = staff;
	}
	
	public EngagementDTO(Engagement engagement) {
		this(
				engagement.getId(),
				engagement.getVersion(),
				new AcademicRoleDTO(engagement.getAcademicRole()),
				new CourseDTO(engagement.getCourse()),
				new StaffDTO(engagement.getStaff())
				
		);
	}
	
	public static Set<EngagementDTO> engagementsToDTOs(Set<Engagement> engagements) {
		return engagements
	            .stream()
	            .map(engagement -> new EngagementDTO(engagement))
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

	public AcademicRoleDTO getAcademicRole() {
		return academicRole;
	}

	public void setAcademicRole(AcademicRoleDTO academicRole) {
		this.academicRole = academicRole;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	public StaffDTO getStaff() {
		return staff;
	}

	public void setStaff(StaffDTO staff) {
		this.staff = staff;
	}

}
