package eobrazovanje.tim6.app.service;

import java.util.Optional;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;

public interface IRoleService {
	
	public Role findById(Long roleId);
	public Role findByName(RoleName roleName);
}
