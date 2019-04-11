
package eobrazovanje.tim6.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	

	
	@ManyToMany
	@JoinTable(name = "course_student", 
	joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"), 
	inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
	//@JsonIgnore 
	private Set<Student> students;
	
	
	
	public Set<Student> getStudents() {
		if (students == null)
			students = new java.util.HashSet<Student>();
		return students;	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

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
