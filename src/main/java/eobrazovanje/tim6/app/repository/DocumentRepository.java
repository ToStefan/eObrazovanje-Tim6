package eobrazovanje.tim6.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	public List<Document> findByStudentId(Long studentId);
	
	public Document findByIdAndStudentId(Long documentId, Long studentId);
	
	

}
