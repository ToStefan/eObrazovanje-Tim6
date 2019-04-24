
package eobrazovanje.tim6.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "academic_roles")
@Where(clause = "deleted=false")
public class AcademicRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "academic_role_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Version
	@Column(name = "version", unique = false, nullable = false)
	private Long version;
	
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
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public Boolean getDeleted() {
		
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		
		this.deleted = deleted;
	}
	
	public Long getVersion() {
		
		return version;
	}
	
	public void setVersion(Long version) {
		
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
