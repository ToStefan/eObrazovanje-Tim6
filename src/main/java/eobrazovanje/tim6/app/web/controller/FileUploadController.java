package eobrazovanje.tim6.app.web.controller;

import java.util.Arrays;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eobrazovanje.tim6.app.service.impl.FileStorageService;
import eobrazovanje.tim6.app.web.dto.DocumentDTO;

/*
 * 
 * If needed outside of the DocumentsController
 * 
 */


@RestController
public class FileUploadController {
	
	@Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/api/upload-file")
    public ResponseEntity<DocumentDTO> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/documents/download-file/")
            .path(fileName)
            .toUriString();
        
        //Availible data:
        //fileName
        //fileDownloadUri
        //file.getContentType() //content type
        //file.getSize() //file size

        DocumentDTO dDTO = new DocumentDTO();
        dDTO.setName(fileName);
        dDTO.setUri(fileDownloadUri);
        
        return new ResponseEntity<DocumentDTO>(dDTO, HttpStatus.OK);
    }
}
