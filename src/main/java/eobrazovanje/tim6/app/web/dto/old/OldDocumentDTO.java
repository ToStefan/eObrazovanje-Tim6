package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Document;

@JsonInclude(Include.NON_NULL)
public class OldDocumentDTO {

	private Long id;
	private String name;
	private String uri;
	private Long version;
	
	public OldDocumentDTO() {
		
	}
	

	public OldDocumentDTO(Long id, String name, String uri, Long version, OldStudentDTO student) {
		super();
		this.id = id;
		this.name = name;
		this.uri = uri;
		this.version = version;
	}

	public OldDocumentDTO(Document document) {
		this(
				document.getId(),
				document.getName(),
				document.getUri(),
				document.getVersion(),
				OldStudentDTO.buildStripped(document.getStudent())
			);
	}
	

	public static Set<OldDocumentDTO> documentsToDTOs(Collection<Document> documents) {
		return documents
	            .stream()
	            .map(document -> new OldDocumentDTO(document))
	            .collect(Collectors.toSet());
	}
	
	
	//==========================================================================
	
	public static OldDocumentDTO buildStripped(Document document) {
		OldDocumentDTO dDTO = new OldDocumentDTO();
		dDTO.setId(document.getId());
		dDTO.setName(dDTO.getName());
		dDTO.setUri(document.getUri());
		dDTO.setVersion(document.getVersion());
		return dDTO;
	}
	
	public static Set<OldDocumentDTO> documentsToStrippedDTOs(Set<Document> documents) {
		return documents
	            .stream()
	            .map(document -> buildStripped(document))
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

}
