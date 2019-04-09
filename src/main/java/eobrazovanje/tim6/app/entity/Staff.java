
package eobrazovanje.tim6.app.entity;

public class Staff {
	
	private Long id;
	private String firstname;
	private String lastname;
	private Boolean deleted = false;
	private Integer version;
	
	public User user;
	public AcademicRole academicRole;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public String getFirstname() {
		
		return firstname;
	}
	
	public void setFirstname(String newFirstname) {
		
		firstname = newFirstname;
	}
	
	public String getLastname() {
		
		return lastname;
	}
	
	public void setLastname(String newLastname) {
		
		lastname = newLastname;
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
