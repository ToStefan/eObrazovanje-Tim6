
package eobrazovanje.tim6.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "courses")
@Where(clause = "deleted=false")
public class Course {
	
	@Id
	@GeneratedValue
	@Column(name = "course_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
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
