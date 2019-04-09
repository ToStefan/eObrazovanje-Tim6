package eobrazovanje.tim6.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "exam_registrations")
@Where(clause = "deleted=false")
public class ExamRegistration {
	
	@Id
	@GeneratedValue
	@Column(name = "exam_registration_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="exam_registration_date" , nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="YYYY-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date date;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@Column(name = "course_id", unique = false, nullable = false)
	public Course course;
	
	@Column(name = "student_id", unique = false, nullable = false)
	public Student student;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long newId) {
		
		id = newId;
	}
	
	public Date getDate() {
		
		return date;
	}
	
	public void setDate(Date newDate) {
		
		date = newDate;
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
	
	public Student getStudent() {
		
		return student;
	}
	
	public void setStudent(Student newStudent) {
		
		if (this.student == null || !this.student.equals(newStudent)) {
			if (this.student != null) {
				Student oldStudent = this.student;
				this.student = null;
				oldStudent.removeExamRegistration(this);
			}
			if (newStudent != null) {
				this.student = newStudent;
				this.student.addExamRegistration(this);
			}
		}
	}
}
