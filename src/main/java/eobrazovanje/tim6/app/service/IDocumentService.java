package eobrazovanje.tim6.app.service;

import java.util.List;

import eobrazovanje.tim6.app.entity.Document;

public interface IDocumentService {
	
	List<Document> findAll();
	List<Document> findByStudentId(Long studentId);
	Document save(Document document);
	void remove(Long documentId);

}
