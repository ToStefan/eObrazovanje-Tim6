
package eobrazovanje.tim6.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.repository.UserRepository;
import eobrazovanje.tim6.app.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
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
