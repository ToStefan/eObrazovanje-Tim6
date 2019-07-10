
package eobrazovanje.tim6.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;
import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.exception.RoleNotFoundException;
import eobrazovanje.tim6.app.exception.UserNotFoundException;
import eobrazovanje.tim6.app.repository.UserRepository;
import eobrazovanje.tim6.app.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(Long roleId) {
		Optional<User> optionalUser = userRepository.findById(roleId);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new UserNotFoundException("No such user");
	}

	@Override
	public User findByUserName(String userName) {
		Optional<User> optionalUser = userRepository.findByUsername(userName);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new UserNotFoundException("No such user");
	}
	
	public boolean usernameExists(String username) {
    	if(userRepository.findByUsername(username) != null) {
    		return true;
    	}
    	return false;
    }
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
	
	
	
}
