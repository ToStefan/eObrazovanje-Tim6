package eobrazovanje.tim6.app.web.dto;

import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.entity.Payment;

public class DocumentDTO {

	private Long id;
	private String name;
	private String uri;
	private Long version;
	public StudentDTO student;
	
	public DocumentDTO() {
		
	}
	

	public DocumentDTO(Long id, String name, String uri, Long version, StudentDTO student) {
		super();
		this.id = id;
		this.name = name;
		this.uri = uri;
		this.version = version;
		this.student = student;
	}

	public DocumentDTO(Document document) {
		this(
				document.getId(),
				document.getName(),
				document.getUri(),
				document.getVersion(),
				new StudentDTO(document.getStudent())
			);
	}
	
	public static Set<DocumentDTO> documentsToDTOs(Set<Document> documents) {
		return documents
	            .stream()
	            .map(document -> new DocumentDTO(document))
	            .collect(Collectors.toSet());
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

}
