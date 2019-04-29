package eobrazovanje.tim6.app.web.dto;

import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.GradeLookup;
import eobrazovanje.tim6.app.entity.Payment;

public class GradeLookupDTO {
	
	private Long id;
	private Integer grade;
	private Integer minPoints;
	private Integer maxPoints;
	
	public GradeLookupDTO() {
		
	}
	
	
	public GradeLookupDTO(Long id, Integer grade, Integer minPoints, Integer maxPoints) {
		super();
		this.id = id;
		this.grade = grade;
		this.minPoints = minPoints;
		this.maxPoints = maxPoints;
	}
	
	public GradeLookupDTO(GradeLookup gradeLookup) {
		this(
				gradeLookup.getId(),
				gradeLookup.getGrade(),
				gradeLookup.getMinPoints(),
				gradeLookup.getMaxPoints()
			);
		
	}
	
	public static Set<GradeLookupDTO> gradeLookupsToDTOs(Set<GradeLookup> gradeLookups) {
		return gradeLookups
	            .stream()
	            .map(lookup -> new GradeLookupDTO(lookup))
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
