package eobrazovanje.tim6.app.web.mapper;



import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.service.impl.RoleService;
import eobrazovanje.tim6.app.web.dto.RegisterDTO;
import eobrazovanje.tim6.app.web.dto.UserDTO;

@Component
public class UserMapper implements Mapper {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User registerDTOtoEntity(RegisterDTO registerDTO) {
		User user = new User();
		user.setUsername(registerDTO.getUsername());         
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.getRoles().add(roleService.findByName(registerDTO.getRole()));
        return user;
	}
	

	public UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setRoles(user.getRoles());
		return userDTO;
	}

	@Override
	public Object toEntity(Object dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set toDTO(Collection entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set toEntity(Collection dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object toDTO(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
