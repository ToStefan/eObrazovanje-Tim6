package eobrazovanje.tim6.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	public Page<Document> findByStudentId(Long studentId, Pageable pageable);
	
	public Document findByIdAndStudentId(Long documentId, Long studentId);
	
	

}
