package eobrazovanje.tim6.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;
import eobrazovanje.tim6.app.exception.RoleNotFoundException;
import eobrazovanje.tim6.app.repository.RoleRepository;
import eobrazovanje.tim6.app.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findById(Long roleId) {
		Optional<Role> optionalRole = roleRepository.findById(roleId);
		if(optionalRole.isPresent()) {
			return optionalRole.get();
		}
		throw new RoleNotFoundException("No such role");
	}

	@Override
	public Role findByName(RoleName roleName) {
		Optional<Role> optionalRole = roleRepository.findByName(roleName);
		if(optionalRole.isPresent()) {
			return optionalRole.get();
		}
		throw new RoleNotFoundException("No such role");
	}
	
	

}
