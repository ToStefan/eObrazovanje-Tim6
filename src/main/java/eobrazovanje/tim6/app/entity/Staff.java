
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "staff")
@Where(clause = "deleted=false")
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "firstname", unique = false, nullable = false)
	private String firstname;
	
	@Column(name = "lastname", unique = false, nullable = false)
	private String lastname;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Version
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id", nullable = false)
	public User user;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Engagement> engagements = new HashSet<Engagement>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "academic_role_id")
	public AcademicRole academicRole;
	
	public Staff() {
		
	}
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public String getFirstname() {
		
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		
		this.firstname = firstname;
	}
	
	public String getLastname() {
		
		return lastname;
	}
	
	public void setLastname(String lastname) {
		
		this.lastname = lastname;
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
	
	public User getUser() {
		
		return user;
	}
	
	public void setUser(User user) {
		
		this.user = user;
	}
	
	public Set<Engagement> getEngagements() {
		
		return engagements;
	}
	
	public void setEngagements(Set<Engagement> engagements) {
		
		this.engagements = engagements;
	}
	
	public AcademicRole getAcademicRole() {
		
		return academicRole;
	}
	
	public void setAcademicRole(AcademicRole academicRole) {
		
		this.academicRole = academicRole;
	}
}
