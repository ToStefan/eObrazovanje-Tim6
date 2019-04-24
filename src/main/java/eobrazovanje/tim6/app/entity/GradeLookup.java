
package eobrazovanje.tim6.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grades_lookup")
public class GradeLookup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "grade", unique = true, nullable = false)
	private Integer grade;
	
	@Column(name = "min_points", unique = true, nullable = false)
	private Integer minPoints;
	
	@Column(name = "max_points", unique = true, nullable = false)
	private Integer maxPoints;
	
	public GradeLookup() {
		
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
	
	public Integer getMinPoints() {
		
		return minPoints;
	}
	
	public void setMinPoints(Integer minPoints) {
		
		this.minPoints = minPoints;
	}
	
	public Integer getMaxPoints() {
		
		return maxPoints;
	}
	
	public void setMaxPoints(Integer maxPoints) {
		
		this.maxPoints = maxPoints;
	}
}
