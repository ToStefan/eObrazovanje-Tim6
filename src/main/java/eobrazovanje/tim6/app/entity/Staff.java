
package eobrazovanje.tim6.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "staff")
@Where(clause = "deleted=false")
public class Staff {
	
	@Id
	@GeneratedValue
	@Column(name = "staff_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "firstname", unique = false, nullable = false)
	private String firstname;
	
	@Column(name = "lastname", unique = false, nullable = false)
	private String lastname;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@Column(name = "user_id", unique = false, nullable = false)
	public User user;
	
	@Column(name = "academic_role_id", unique = false, nullable = false)
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
