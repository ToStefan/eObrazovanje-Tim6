
package eobrazovanje.tim6.app.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "grades")
@Where(clause = "deleted=false")
public class Grade {
	
	@Id
	@GeneratedValue
	@Column(name = "grade_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "grade", unique = true, nullable = false)
	private Integer grade;
	
	@Column(name = "total_points", unique = true, nullable = false)
	private Integer totalPoints;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	public Set<Exam> exam = new HashSet<Exam>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id")
	public Student student;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
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
	
	public Set<Exam> getExam() {
		
		return exam;
	}
	
	public void setExam(Set<Exam> exam) {
		
		this.exam = exam;
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
	
	public Integer getVersion() {
		
		return version;
	}
	
	public void setVersion(Integer version) {
		
		this.version = version;
	}
}
