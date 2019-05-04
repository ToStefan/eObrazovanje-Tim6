package eobrazovanje.tim6.app.web.dto;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;

public class RoleDTO {

	private Long id;
	private RoleName name;

	public RoleDTO() {

	}

	public RoleDTO(Long id, RoleName name) {
		super();
		this.id = id;
		this.name = name;
	}

	public RoleDTO(Role role) {
		this(role.getId(), role.getName());
	}
	
	public static Set<RoleDTO> rolesToDTOs(Collection<Role> roles) {
		return roles
	            .stream()
	            .map(role -> new RoleDTO(role))
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
