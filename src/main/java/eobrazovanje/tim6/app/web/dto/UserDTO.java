package eobrazovanje.tim6.app.web.dto;

import java.util.HashSet;
import java.util.Set;

import eobrazovanje.tim6.app.entity.User;

public class UserDTO {

	private Long id;
	private String username;
	private Long version;
	public Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
		
	}
	
	public UserDTO(Long id, String username, Long version, Set<RoleDTO> roles) {
		super();
		this.id = id;
		this.username = username;
		this.version = version;
		this.roles = roles;
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getUsername(), user.getVersion(), RoleDTO.rolesToDTOs(user.getRoles()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

}
