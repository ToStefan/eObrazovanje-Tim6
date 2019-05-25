package eobrazovanje.tim6.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import eobrazovanje.tim6.app.entity.Document;

public interface IDocumentService {
	
	Page<Document> findAll(Pageable pageable);
	Document findOne(Long documentId);
	Page<Document> findByStudentId(Long studentId, Pageable pageable);
	Document findOneByStudentId(Long documentId, Long studentId);
	Document save(Document document);
	Boolean remove(Long documentId);
	
}
