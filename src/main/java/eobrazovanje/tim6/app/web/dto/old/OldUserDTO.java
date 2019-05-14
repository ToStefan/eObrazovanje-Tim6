package eobrazovanje.tim6.app.web.dto.old;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eobrazovanje.tim6.app.entity.User;

@JsonInclude(Include.NON_NULL)
public class OldUserDTO {

	private Long id;
	private String username;
	private Long version;
	public Set<OldRoleDTO> roles = new HashSet<>();
	
	public OldUserDTO() {
		
	}
	
	public OldUserDTO(Long id, String username, Long version, Set<OldRoleDTO> roles) {
		super();
		this.id = id;
		this.username = username;
		this.version = version;
		this.roles = roles;
	}
	
	public OldUserDTO(User user) {
		this(user.getId(), user.getUsername(), user.getVersion(), OldRoleDTO.rolesToDTOs(user.getRoles()));
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

	public Set<OldRoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<OldRoleDTO> roles) {
		this.roles = roles;
	}

}
