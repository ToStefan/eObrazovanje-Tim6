
package eobrazovanje.tim6.app.entity;

public class Engagement {
	
	private Long id;
	private Boolean deleted = false;
	private Integer version;
	
	public AcademicRole academicRole;
	public Course course;
	public Staff staff;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean newDeleted) {
		
		deleted = newDeleted;
	}
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer newVersion) {
		
		version = newVersion;
	}
	
}
