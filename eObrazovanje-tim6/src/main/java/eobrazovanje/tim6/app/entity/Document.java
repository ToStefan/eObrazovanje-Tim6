package eobrazovanje.tim6.app.entity;


public class Document {
	
	private Long id;
	private String name;
	private String uri;
	private Boolean deleted = false;
	private Integer version;
	
	public Student student;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String newName) {
		
		name = newName;
	}
	
	public String getUri() {
		
		return uri;
	}
	
	public void setUri(String newUri) {
		
		uri = newUri;
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
	
	public Student getStudent() {
		
		return student;
	}
	
	public void setStudent(Student newStudent) {
		
		if (this.student == null || !this.student.equals(newStudent)) {
			if (this.student != null) {
				Student oldStudent = this.student;
				this.student = null;
				oldStudent.removeDocument(this);
			}
			if (newStudent != null) {
				this.student = newStudent;
				this.student.addDocument(this);
			}
		}
	}
	
}
