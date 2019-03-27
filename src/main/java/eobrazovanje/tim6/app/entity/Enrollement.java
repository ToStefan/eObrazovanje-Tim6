package eobrazovanje.tim6.app.entity;


public class Enrollement {
	
	private Long id;
	
	public Course course;
	public Student student;
	
	public Long getId() {
		
		return id;
	}
	
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public Course getCourse() {
		
		return course;
	}
	
	public void setCourse(Course course) {
		
		this.course = course;
	}
	
	public Student getStudent() {
		
		return student;
	}
	
	public void setStudent(Student student) {
		
		this.student = student;
	}
	
}
