package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.web.dto.DocumentDTO;

@Component
public class DocumentMapper implements Mapper<Document, DocumentDTO> {

	@Autowired
	StudentMapper studentMapper;
	
	
	@Override
	public DocumentDTO toDTO(Document document) {
		DocumentDTO dDTO = new DocumentDTO();
		dDTO.setId(document.getId());
		dDTO.setName(document.getName());
		dDTO.setUri(document.getUri());
		dDTO.setDeleted(document.getDeleted());
		dDTO.setVersion(document.getVersion());
		dDTO.setStudent(studentMapper.toStrippedDTO(document.getStudent()));
		
		return dDTO;
		
		
	}
	
	@Override
	public Set<DocumentDTO> toDTO(Collection<Document> entities) {
		return entities
				.stream()
				.map(document -> toDTO(document))
				.collect(Collectors.toSet());
	}
	
	public Set<DocumentDTO> toDTO(Page<Document> documentPage) {
		return documentPage
				.stream()
				.map(document -> toDTO(document))
				.collect(Collectors.toSet());
	}
	
	//public DocmentDTO toDTOWithoutStudent() - Segedinac naming conventions
	public DocumentDTO toStrippedDTO(Document document) {
		DocumentDTO dDTO = new DocumentDTO();
		dDTO.setId(document.getId());
		dDTO.setName(document.getName());
		dDTO.setUri(document.getUri());
		dDTO.setDeleted(document.getDeleted());
		dDTO.setVersion(document.getVersion());
		
		return dDTO;
		
	}
	
	public Set<DocumentDTO> toStrippedDTO(Collection<Document> documents) {
		return documents
				.stream()
				.map(document -> toStrippedDTO(document))
				.collect(Collectors.toSet());
		
	}

	@Override
	public Document toEntity(DocumentDTO documentDTO) {
		Document document = new Document();
		document.setName(documentDTO.getName());
		document.setUri(documentDTO.getUri());
		document.setDeleted(documentDTO.getDeleted());
		document.setVersion(documentDTO.getVersion());
		//document.setStudent(studentMapper.toEntity(documentDTO.getStudent()));
		
		return document;
	}
	
	@Override
	public Set<Document> toEntity(Collection<DocumentDTO> dtos) {
		return dtos
				.stream()
				.map(dDTO -> toEntity(dDTO))
				.collect(Collectors.toSet());
	}
	
	public Document toExistingEntity(Document document, DocumentDTO documentDTO) {
		document.setName(documentDTO.getName());
		document.setUri(documentDTO.getUri());
		document.setDeleted(documentDTO.getDeleted());
		document.setVersion(documentDTO.getVersion());
		return document;
	}

	
	
	
	
	
	

}
