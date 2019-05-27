package eobrazovanje.tim6.app.web.dto;

public class EngagementDTO {
	
	private Long id;
	private Boolean deleted;
	private Long version;
	private CourseDTO courseDTO;
	private AcademicRoleDTO academicRoleDTO;
	private StaffDTO staffDTO;
	
	public EngagementDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public CourseDTO getCourseDTO() {
		return courseDTO;
	}

	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}

	public AcademicRoleDTO getAcademicRoleDTO() {
		return academicRoleDTO;
	}

	public void setAcademicRoleDTO(AcademicRoleDTO academicRoleDTO) {
		this.academicRoleDTO = academicRoleDTO;
	}

	public StaffDTO getStaffDTO() {
		return staffDTO;
	}

	public void setStaffDTO(StaffDTO staffDTO) {
		this.staffDTO = staffDTO;
	}
	
	
}
