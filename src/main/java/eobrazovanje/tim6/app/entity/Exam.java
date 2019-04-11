package eobrazovanje.tim6.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Entity
@Table(name = "exames")
@Where(clause = "deleted=false")
public class Exam {
	
	@Id
	@GeneratedValue
	@Column(name = "exam_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "pass", unique = false, nullable = false)
	private Boolean pass;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "points", unique = false, nullable = false)
	private Integer points;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@Column(name = "student_id", unique = false, nullable = false)
	public Student student;
	
	
	@Column(name = "course_id", unique = false, nullable = false)
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
