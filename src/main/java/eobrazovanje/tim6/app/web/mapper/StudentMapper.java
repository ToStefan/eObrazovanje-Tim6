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
	
	@Autowired
	PaymentMapper paymentMapper;

	@Override
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
		sDTO.setDeleted(student.getDeleted());
		
		//sDTO.setDocuments(documentMapper.toDTO(student.getDocuments()));
		//sDTO.setPayments(paymentMapper.toStrippedDTO(student.getPayments()));
		
		return sDTO;
	}
	
	public StudentDTO toStrippedDTO(Student student) {
		StudentDTO sDTO = new StudentDTO();
		sDTO.setId(student.getId());
		sDTO.setFirstName(student.getFirstName());
		sDTO.setLastName(student.getLastName());
		sDTO.setIdentificationNumber(student.getIdentificationNumber());
		sDTO.setAccountBalance(student.getAccountBalance());
		sDTO.setAdress(student.getAdress());
		sDTO.setPhoneNumber(student.getPhoneNumber());
		sDTO.setVersion(student.getVersion());
		sDTO.setDeleted(student.getDeleted());
		
		return sDTO;
	}
	
	public Set<StudentDTO> toStrippedDTO(Collection<Student> students){
		return students
			.stream()
			.map(student -> toStrippedDTO(student))
			.collect(Collectors.toSet());
	}

	@Override
	public Student toEntity(StudentDTO studentDTO) {
		Student student = new Student();
		
		//id - neither create nor update needs it?
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setAdress(studentDTO.getAdress());
		student.setAccountBalance(studentDTO.getAccountBalance());
		student.setIdentificationNumber(studentDTO.getIdentificationNumber());
		student.setPhoneNumber(studentDTO.getPhoneNumber());
		
		//https://stackoverflow.com/questions/10648515/using-version-in-spring-data-project
		//Baeldung - musnt update or increment it
		//Test this!
		student.setVersion(studentDTO.getVersion());
		
		//Send the deleted attribute from the front end and delete it that way
		student.setDeleted(studentDTO.getDeleted());
		
		//student.setDocuments(documentMapper.toEntity(studentDTO.getDocuments()));
		//student.setPayments(paymentMapper.toEntity(studentDTO.getPayments()));
		
		return student;
	}

	@Override
	public Set<StudentDTO> toDTO(Collection<Student> entities) {
		return entities
	            .stream()
	            .map(student -> toDTO(student))
	            .collect(Collectors.toSet());
	}

	@Override
	public Set<Student> toEntity(Collection<StudentDTO> dtos) {
		return dtos
	            .stream()
	            .map(sDTO -> toEntity(sDTO))
	            .collect(Collectors.toSet());
	}
	

	
}
