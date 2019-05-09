package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.web.dto.DocumentDTO;

@Component
public class DocumentMapper implements Mapper<Document, DocumentDTO> {

	@Override
	public DocumentDTO toDTO(Document e) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public DocmentDTO toDTOWithoutStudent()

	@Override
	public Document toEntity(DocumentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DocumentDTO> toDTO(Set<Document> es) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Document> toEntity(Set<DocumentDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
