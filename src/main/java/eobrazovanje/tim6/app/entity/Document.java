
package eobrazovanje.tim6.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "documents")
@Where(clause = "deleted=false")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "uri", unique = false, nullable = false)
	private String uri;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private Boolean deleted = false;
	
	@Version
	@Column(name = "version", unique = false, nullable = false)
	private Integer version;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "student_id")
	public Student student;
	
	public Document() {
		
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
	
	public String getUri() {
		
		return uri;
	}
	
	public void setUri(String newUri) {
		
		uri = newUri;
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
	
	public void setStudent(Student student) {
		
		this.student = student;
	}
}
