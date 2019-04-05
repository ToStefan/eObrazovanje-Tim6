package eobrazovanje.tim6.app.entity;


public class Exam {
	
	private Long id;
	private Boolean pass;
	private String name;
	private Integer points;
	private Boolean deleted = false;
	private Integer version;
	
	public Student student;
	public Course course;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Boolean getPass() {
		
		return pass;
	}
	
	public void setPass(Boolean newPass) {
		
		pass = newPass;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String newName) {
		
		name = newName;
	}
	
	public Integer getPoints() {
		
		return points;
	}
	
	public void setPoints(Integer newPoints) {
		
		points = newPoints;
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
