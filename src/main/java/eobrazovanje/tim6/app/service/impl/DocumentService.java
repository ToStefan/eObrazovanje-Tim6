package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eobrazovanje.tim6.app.repository.DocumentRepository;
import eobrazovanje.tim6.app.service.IDocumentService;

@Service
public class DocumentService implements IDocumentService {
	
	@Autowired
	private DocumentRepository documentRep;

}
