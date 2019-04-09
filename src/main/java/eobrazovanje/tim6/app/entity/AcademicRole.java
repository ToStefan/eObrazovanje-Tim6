package eobrazovanje.tim6.app.entity;

public class AcademicRole {
	
	private Long id;
	private Long name;
	private Boolean deleted = false;
	private Integer version;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Long getName() {
		
		return name;
	}
	
	public void setName(Long newName) {
		
		name = newName;
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
