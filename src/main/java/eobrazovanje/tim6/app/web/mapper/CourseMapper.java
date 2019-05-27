package eobrazovanje.tim6.app.web.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.Course;
import eobrazovanje.tim6.app.entity.Payment;
import eobrazovanje.tim6.app.web.dto.CourseDTO;
import eobrazovanje.tim6.app.web.dto.PaymentDTO;

@Component
public class CourseMapper implements Mapper<Course, CourseDTO> {

	@Override
	public CourseDTO toDTO(Course entity) {
		
		CourseDTO courseDTO=new CourseDTO();
		courseDTO.setId(entity.getId());
		courseDTO.setName(entity.getName());
		courseDTO.setYear(entity.getYear());
		courseDTO.setDeleted(entity.getDeleted());
		courseDTO.setVersion(entity.getVersion());
//		TODO ubaciti listu Stuff kad uradim DTO za njih 
//		courseDTO.setEngagements(entity.getEngagements());
		
		return courseDTO;
	}

	@Override
	public Course toEntity(CourseDTO dto) {
		Course course=new Course();
		
		//without id for post method
		course.setName(dto.getName());
		course.setYear(dto.getYear());
		course.setDeleted(dto.getDeleted());
		course.setVersion(dto.getVersion());
		
		return course;
	}
	
	public Course toEntityWithId(CourseDTO dto) {
		Course course=new Course();
		
		//with id for put and delete method
		course.setId(dto.getId());
		course.setName(dto.getName());
		course.setYear(dto.getYear());
		course.setDeleted(dto.getDeleted());
		course.setVersion(dto.getVersion());
		
		return course;
	}

	@Override
	public Set<CourseDTO> toDTO(Collection<Course> entities) {
		return entities
	            .stream()
	            .map(course -> toDTO(course))
	            .collect(Collectors.toSet());
	}
	public Set<CourseDTO> toDTO(Page<Course> coursesPage) {
		return coursesPage
				.stream()
				.map(course -> toDTO(course))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<Course> toEntity(Collection<CourseDTO> dtos) {
		return dtos
	            .stream()
	            .map(courseDTO -> toEntity(courseDTO))
	            .collect(Collectors.toSet());
	}

}
