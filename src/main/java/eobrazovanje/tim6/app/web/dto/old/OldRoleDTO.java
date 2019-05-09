package eobrazovanje.tim6.app.web.dto.old;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;

@JsonInclude(Include.NON_NULL)
public class OldRoleDTO {

	private Long id;
	private RoleName name;

	public OldRoleDTO() {

	}

	public OldRoleDTO(Long id, RoleName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public OldRoleDTO(Role role) {
		this(role.getId(), role.getName());
	}
	
	public static Set<OldRoleDTO> rolesToDTOs(Collection<Role> roles) {
		return roles
	            .stream()
	            .map(role -> new OldRoleDTO(role))
	            .collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	
	
	

}
