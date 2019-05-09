package eobrazovanje.tim6.app.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTML.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.entity.Payment;
import eobrazovanje.tim6.app.service.impl.DocumentService;
import eobrazovanje.tim6.app.service.impl.StudentService;
import eobrazovanje.tim6.app.web.dto.DocumentDTO;

@RestController
@RequestMapping(value = "/")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private StudentService studentService;
	
	//General:
	
	@GetMapping(value = "api/documents")
	public ResponseEntity<Set<DocumentDTO>> getDocuments(){
		List<Document> documents = documentService.findAll();
		if(documents == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<DocumentDTO>>(DocumentDTO.documentsToDTOs(documents), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/documents/{id}")
	public ResponseEntity<DocumentDTO> getDocument(@PathVariable("id") Long id){
		Document document = documentService.findOne(id);
		if(document == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.OK);
		
	}
	
	//Nested:
	
	@GetMapping(value = "api/students/{id}/documents")
	public ResponseEntity<Set<DocumentDTO>> getStudentDocuments(@PathVariable("id") Long id){
		List<Document> studentDocuments = documentService.findByStudentId(id);
		if(studentDocuments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<DocumentDTO>>(DocumentDTO.documentsToDTOs(studentDocuments), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/students/{student-id}/documents/{document-id}")
	public ResponseEntity<DocumentDTO> getStudentDocument(@PathVariable("student-id") Long studentId, @PathVariable("document-id") Long documentId){
		Document studentDocument = documentService.findOneByStudentId(documentId, studentId);
		if(studentDocument == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(studentDocument), HttpStatus.OK);
		
	}
	
	//Create, Update, Delete:
	

	@PostMapping(value = "api/documents", consumes = "application/json")
	public ResponseEntity<DocumentDTO> saveDocument(@RequestBody DocumentDTO documentDTO){
		if(documentDTO == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Document document = new Document();
		document.setName(documentDTO.getName());
		document.setUri(documentDTO.getUri());
		document.setDeleted(false);
		//document.setStudent(studentService.findOne(documentDTO.getStudent().getId()));
		
		
		document = documentService.save(document);
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "api/documents", consumes = "application/json")
	public ResponseEntity<DocumentDTO> updatePost(@RequestBody DocumentDTO documentDTO){
		Document document = documentService.findOne(documentDTO.getId());
		if (document == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		document.setName(documentDTO.getName());
		document.setUri(documentDTO.getUri());
		document.setDeleted(false);
		//document.setStudent(studentService.findOne(documentDTO.getStudent().getId()));
		
		
		document = documentService.save(document);
		return new ResponseEntity<DocumentDTO>(new DocumentDTO(document), HttpStatus.CREATED);	
	}
	
	@DeleteMapping(value = "api/documents/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id){
		Document document = documentService.findOne(id);
		if(document == null ) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		document.setDeleted(true);
		documentService.save(document);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	

}
