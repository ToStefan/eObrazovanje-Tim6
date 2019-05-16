package eobrazovanje.tim6.app.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eobrazovanje.tim6.app.entity.Document;
import eobrazovanje.tim6.app.service.impl.DocumentService;
import eobrazovanje.tim6.app.service.impl.FileStorageService;
import eobrazovanje.tim6.app.web.dto.DocumentDTO;
import eobrazovanje.tim6.app.web.mapper.DocumentMapper;

@RestController
@RequestMapping(value = "/")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private DocumentMapper documentMapper;
	
	@Autowired
    private FileStorageService fileStorageService;
	
	
	//General:
	
	@GetMapping(value = "api/documents")
	public ResponseEntity<Set<DocumentDTO>> getDocuments(Pageable pageable){
		Page<Document> documents = documentService.findAll(pageable);
		if(documents == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<DocumentDTO>>(documentMapper.toDTO(documents), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/documents/{id}")
	public ResponseEntity<DocumentDTO> getDocument(@PathVariable("id") Long id){
		Document document = documentService.findOne(id);
		if(document == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentDTO>(documentMapper.toDTO(document), HttpStatus.OK);
		
	}
	
	//Nested:
	
	@GetMapping(value = "api/students/{id}/documents")
	public ResponseEntity<Set<DocumentDTO>> getStudentDocuments(@PathVariable("id") Long id, Pageable pageable){
		Page<Document> studentDocuments = documentService.findByStudentId(id, pageable);
		if(studentDocuments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<DocumentDTO>>(documentMapper.toDTO(studentDocuments), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "api/students/{student-id}/documents/{document-id}")
	public ResponseEntity<DocumentDTO> getStudentDocument(@PathVariable("student-id") Long studentId, @PathVariable("document-id") Long documentId){
		Document studentDocument = documentService.findOneByStudentId(documentId, studentId);
		if(studentDocument == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DocumentDTO>(documentMapper.toDTO(studentDocument), HttpStatus.OK);
		
	}
	
	//Create, Update, Delete:
	
	//request param - form field of file with the value of a chosen file
	//plus the json body
	@PostMapping(value = "api/documents", consumes = "application/json")
	public ResponseEntity<DocumentDTO> saveDocument(@RequestBody DocumentDTO documentDTO, @RequestParam("file") MultipartFile file){
		if(documentDTO == null || file == null) {
			return new ResponseEntity<DocumentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/documents/download-file/")
            .path(fileName)
            .toUriString();
        
        documentDTO.setFileName(fileName);
        documentDTO.setUri(fileDownloadUri);

		Document document = documentService.save(documentMapper.toEntity(documentDTO));
		
		return new ResponseEntity<DocumentDTO>(documentMapper.toDTO(document), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "api/documents", consumes = "application/json")
	public ResponseEntity<DocumentDTO> updatePost(@RequestBody DocumentDTO documentDTO){
		Document document = documentService.findOne(documentDTO.getId());
		if (document == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
//		document.setName(documentDTO.getName());
//		document.setUri(documentDTO.getUri());
//		document.setDeleted(false);
//		document.setStudent(studentService.findOne(documentDTO.getStudent().getId()));
		
		//instead:
		document = documentService.save(documentMapper.toExistingEntity(document, documentDTO));
		
		return new ResponseEntity<DocumentDTO>(documentMapper.toDTO(document), HttpStatus.CREATED);	
	}
	
	@DeleteMapping(value = "api/documents/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable("id") Long id){	
		if(documentService.remove(id)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
