package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Student;
import eobrazovanje.tim6.app.web.dto.StudentDTO;

@Component
public class StudentMapper implements Mapper<Student, StudentDTO> {
	
	@Autowired
	DocumentMapper documentMapper;
	
	public StudentDTO toDTO(Student student) {
		StudentDTO sDTO = new StudentDTO();
		sDTO.setId(student.getId());
		sDTO.setFirstName(student.getFirstName());
		sDTO.setLastName(student.getLastName());
		sDTO.setIdentificationNumber(student.getIdentificationNumber());
		sDTO.setAccountBalance(student.getAccountBalance());
		sDTO.setAdress(student.getAdress());
		sDTO.setPhoneNumber(student.getPhoneNumber());
		sDTO.setVersion(student.getVersion());
		sDTO.setDocuments(documentMapper.toDTO(student.getDocuments()));
		return sDTO;
	}
	
	public Student toEntity(StudentDTO studentDTO) {
		//TODO implementirati logiku konverzije dto objekta u entiti objekat
		return null;
	}
	
	public Set<StudentDTO> toDTO(Set<Student> students){
		return students
	            .stream()
	            .map(student -> toDTO(student))
	            .collect(Collectors.toSet());
		
		
	}
	
	public Set<Student> toEntity(Set<StudentDTO> studentiDTO){
		// TODO implementirati
		return null;
	}
	
}
