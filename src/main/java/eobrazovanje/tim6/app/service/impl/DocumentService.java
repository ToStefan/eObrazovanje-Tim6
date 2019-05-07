package eobrazovanje.tim6.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.repository.DocumentRepository;
import eobrazovanje.tim6.app.service.IDocumentService;

@Service
public class DocumentService implements IDocumentService {
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Override
	public List<Document> findAll() {
		return documentRepository.findAll();
	}
	
	
	@Override
	public Document findOne(Long documentId) {
		return documentRepository.getOne(documentId);
	}


	@Override
	public List<Document> findByStudentId(Long studentId) {
		return documentRepository.findByStudentId(studentId);
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
	public void remove(Long documentId) {
		documentRepository.deleteById(documentId);

	}
	
	

}