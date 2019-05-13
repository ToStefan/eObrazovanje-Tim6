
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "grades")
@Where(clause = "deleted=false")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grade_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "grade", unique = true, nullable = false)
	private Integer grade;
	
	@Column(name = "total_points", unique = true, nullable = false)
	private Integer totalPoints;
	
	//@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@ManyToMany
	@JoinTable(name = "grades_pre_exam_obligations", joinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "grade_id"), inverseJoinColumns = @JoinColumn(name = "pre_exam_obligation_id", referencedColumnName = "pre_exam_obligation_id"))
	public Set<PreExamObligation> preExamObligations = new HashSet<PreExamObligation>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id")
	public Student student;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "course_id", nullable = false)
	public Course course;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Version
	@Column(name = "version", unique = false, nullable = false)
	private Long version;
	
	public Grade() {
		
	}
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public Integer getGrade() {
		
		return grade;
	}
	
	public void setGrade(Integer grade) {
		
		this.grade = grade;
	}
	
	public Integer getTotalPoints() {
		
		return totalPoints;
	}
	
	public void setTotalPoints(Integer totalPoints) {
		
		this.totalPoints = totalPoints;
	}
	
	public Set<PreExamObligation> getPreExamObligations() {
		
		return preExamObligations;
	}
	
	public void setPreExamObligations(Set<PreExamObligation> preExamObligations) {
		
		this.preExamObligations = preExamObligations;
	}
	
	public Student getStudent() {
		
		return student;
	}
	
	public void setStudent(Student student) {
		
		this.student = student;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
