package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.web.dto.DocumentDTO;
import eobrazovanje.tim6.app.web.dto.old.OldDocumentDTO;

@Component
public class DocumentMapper implements Mapper<Document, DocumentDTO> {

	@Override
	public DocumentDTO toDTO(Document enitity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document toEntity(DocumentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DocumentDTO> toDTO(Collection<Document> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Document> toEntity(Collection<DocumentDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//public DocmentDTO toDTOWithoutStudent()
	
	
	

}
