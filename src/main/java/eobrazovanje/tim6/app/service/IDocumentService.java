package eobrazovanje.tim6.app.service;

import java.util.List;

import eobrazovanje.tim6.app.entity.Document;

public interface IDocumentService {
	
	List<Document> findAll();
	Document findOne(Long documentId);
	List<Document> findByStudentId(Long studentId);
	Document findOneByStudentId(Long documentId, Long studentId);
	Document save(Document document);
	Boolean remove(Long documentId);
	
}
