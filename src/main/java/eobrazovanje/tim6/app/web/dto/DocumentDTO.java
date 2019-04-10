package eobrazovanje.tim6.app.web.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eobrazovanje.tim6.app.service.impl.DocumentService;

@RestController
@RequestMapping(value = "api/documents")
public class DocumentDTO {
	
	@Autowired
	private DocumentService documentService;

}
