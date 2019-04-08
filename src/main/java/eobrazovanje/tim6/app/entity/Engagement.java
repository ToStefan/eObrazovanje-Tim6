
package eobrazovanje.tim6.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "engagements")
@Where(clause = "deleted=false")
public class Engagement {
	
	@Id
	@GeneratedValue
	@Column(name = "engagement_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@Column(name = "academic_role_id", unique = false, nullable = false)
	public AcademicRole academicRole;
	
	@Column(name = "course_id", unique = false, nullable = false)
	public Course course;
	
	@Column(name = "staff_id", unique = false, nullable = false)
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
