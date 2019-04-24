
package eobrazovanje.tim6.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "exames")
@Where(clause = "deleted=false")
public class Exam {
	
	@Id
	@GeneratedValue
	@Column(name = "exam_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "points", unique = false, nullable = false)
	private Integer points;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@Column(name = "is_last_exam", unique = false, nullable = false)
	private Boolean isLastExam;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id")
	public Student student;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "course_id")
	public Course course;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "exam_registration_id", nullable = false)
	public ExamRegistration examRegistration;
	
	public Exam() {
		
	}
	
}
