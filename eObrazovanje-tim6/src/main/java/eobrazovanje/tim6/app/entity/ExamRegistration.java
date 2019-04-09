package eobrazovanje.tim6.app.entity;

import java.util.Date;

public class ExamRegistration {
	
	private Long id;
	private Date date;
	private Boolean deleted = false;
	private Integer version;
	
	public Course course;
	public Student student;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Date getDate() {
		
		return date;
	}
	
	public void setDate(Date newDate) {
		
		date = newDate;
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
				oldStudent.removeExamRegistration(this);
			}
			if (newStudent != null) {
				this.student = newStudent;
				this.student.addExamRegistration(this);
			}
		}
	}
}
