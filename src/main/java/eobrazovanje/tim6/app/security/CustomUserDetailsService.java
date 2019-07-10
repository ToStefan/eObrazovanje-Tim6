
package eobrazovanje.tim6.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.service.impl.UserService;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findByUserName(username);
		
		return UserPrincipal.create(user);
	}
	
	@Transactional
	public UserDetails loadUserById(long id) {
		
		User user = userService.findById(id);
		
		return UserPrincipal.create(user);
	}
	
}
