package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.GradeLookup;

@JsonInclude(Include.NON_NULL)
public class OldGradeLookupDTO {
	
	private Long id;
	private Integer grade;
	private Integer minPoints;
	private Integer maxPoints;
	
	public OldGradeLookupDTO() {
		
	}
	
	
	public OldGradeLookupDTO(Long id, Integer grade, Integer minPoints, Integer maxPoints) {
		super();
		this.id = id;
		this.grade = grade;
		this.minPoints = minPoints;
		this.maxPoints = maxPoints;
	}
	
	public OldGradeLookupDTO(GradeLookup gradeLookup) {
		this(
				gradeLookup.getId(),
				gradeLookup.getGrade(),
				gradeLookup.getMinPoints(),
				gradeLookup.getMaxPoints()
			);
		
	}
	
	public static Set<OldGradeLookupDTO> gradeLookupsToDTOs(Collection<GradeLookup> gradeLookups) {
		return gradeLookups
	            .stream()
	            .map(lookup -> new OldGradeLookupDTO(lookup))
	            .collect(Collectors.toSet());
	}
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getMinPoints() {
		return minPoints;
	}
	public void setMinPoints(Integer minPoints) {
		this.minPoints = minPoints;
	}
	public Integer getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	
	
	
}
