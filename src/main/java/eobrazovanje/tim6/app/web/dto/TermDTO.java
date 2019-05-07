package eobrazovanje.tim6.app.web.dto;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.Term;


public class TermDTO {
	

	private Long id;
	private String name;
	private Date dateStart;
	private Date dateEnd;
	private Long version;
	private Boolean current;
	
	
	public TermDTO() {
		
	}
	
	
	public TermDTO(Long id, String name, Date dateStart, Date dateEnd, Long version, Boolean current) {
		super();
		this.id = id;
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.version = version;
		this.current = current;
	}
	
	public TermDTO(Term term) {
		this(
				term.getId(),
				term.getName(),
				term.getDateStart(),
				term.getDateEnd(),
				term.getVersion(),
				term.getCurrent()
			);
	}


	public static Set<TermDTO> termsToDTOs(Collection<Term> terms) {
		return terms
	            .stream()
	            .map(term -> new TermDTO(term))
	            .collect(Collectors.toSet());
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Boolean getCurrent() {
		return current;
	}
	public void setCurrent(Boolean current) {
		this.current = current;
	}
	
	

}
