package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Student;
import eobrazovanje.tim6.app.web.dto.StudentDTO;

@Component
public class StudentMapper implements Mapper<Student, StudentDTO> {
	
	@Autowired
	DocumentMapper documentMapper;

	@Override
	public StudentDTO toDTO(Student student) {
//		Student sDTO = new Student();
//		sDTO.setId(student.getId());
//		sDTO.setFirstName(student.getFirstName());
//		sDTO.setLastName(student.getLastName());
//		sDTO.setIdentificationNumber(student.getIdentificationNumber());
//		sDTO.setAccountBalance(student.getAccountBalance());
//		sDTO.setAdress(student.getAdress());
//		sDTO.setPhoneNumber(student.getPhoneNumber());
//		sDTO.setVersion(student.getVersion());
		
		//sDTO.setDocuments(documentMapper.toDTO(student.getDocuments().stream().collect(Collectors.toSet())));
		//return sDTO;
		
		return null;
	}

	@Override
	public Student toEntity(StudentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<StudentDTO> toDTO(Collection<Student> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Student> toEntity(Collection<StudentDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public StudentDTO toDTO(Student student) {
//		Student sDTO = new Student();
//		sDTO.setId(student.getId());
//		sDTO.setFirstName(student.getFirstName());
//		sDTO.setLastName(student.getLastName());
//		sDTO.setIdentificationNumber(student.getIdentificationNumber());
//		sDTO.setAccountBalance(student.getAccountBalance());
//		sDTO.setAdress(student.getAdress());
//		sDTO.setPhoneNumber(student.getPhoneNumber());
//		sDTO.setVersion(student.getVersion());
//		sDTO.setDocuments(documentMapper.toDTO(student.getDocuments()));
//		return sDTO;
//	}
//	
//	public Student toEntity(OldStudentDTO studentDTO) {
//		//TODO implementirati logiku konverzije dto objekta u entiti objekat
//		return null;
//	}
//	
//	public List<OldStudentDTO> toDTO(List<Student> students){
//		return students
//	            .stream()
//	            .map(student -> toDTO(student))
//	            .collect(Collectors.toList());
//		
//		
//	}
//	
//	@Override
//	public List<Student> toEntity(List<OldStudentDTO> studentDTOs) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
