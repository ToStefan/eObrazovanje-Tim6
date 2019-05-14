package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.repository.DocumentRepository;
import eobrazovanje.tim6.app.service.IDocumentService;

@Service
public class DocumentService implements IDocumentService {
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Override
	public Page<Document> findAll(Pageable pageable) {
		return documentRepository.findAll(pageable);
	}
	
	
	@Override
	public Document findOne(Long documentId) {
		return documentRepository.getOne(documentId);
	}


	@Override
	public Page<Document> findByStudentId(Long studentId, Pageable pageable) {
		return documentRepository.findByStudentId(studentId, pageable);
	}
	

	@Override
	public Document findOneByStudentId(Long documentId, Long studentId) {
		return documentRepository.findByIdAndStudentId(documentId, studentId);
	}

	@Override
	public Document save(Document document) {
		return documentRepository.save(document);
	}

	@Override
	public Boolean remove(Long documentId) {
		//Physical deletion:
		//documentRepository.deleteById(documentId);
		
		//Logical deletion:
		//Not a problem here, but with other entites, cascade deletion needs to be solved
		Document document = findOne(documentId);
		if(document != null) {
			document.setDeleted(true);
			save(document);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	

}
