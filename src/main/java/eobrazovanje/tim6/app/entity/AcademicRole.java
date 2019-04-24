
package eobrazovanje.tim6.app.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "academic_roles")
@Where(clause = "deleted=false")
public class AcademicRole {
	
	@Id
	@GeneratedValue
	@Column(name = "academic_role_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private Long name;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@OneToMany(mappedBy = "academicRole", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Staff> staffs = new HashSet<Staff>();
	
	@OneToMany(mappedBy = "academicRole", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Engagement> engagements = new HashSet<Engagement>();
	
	public AcademicRole() {
		
	}
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public Long getName() {
		
		return name;
	}
	
	public void setName(Long name) {
		
		this.name = name;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		
		this.deleted = deleted;
	}
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer version) {
		
		this.version = version;
	}
	
	public Set<Staff> getStaffs() {
		
		return staffs;
	}
	
	public void setStaffs(Set<Staff> staffs) {
		
		this.staffs = staffs;
	}
	
	public Set<Engagement> getEngagements() {
		
		return engagements;
	}
	
	public void setEngagements(Set<Engagement> engagements) {
		
		this.engagements = engagements;
	}
}
