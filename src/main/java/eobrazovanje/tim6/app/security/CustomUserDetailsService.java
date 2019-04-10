package eobrazovanje.tim6.app.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    UserRepository userRepository;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		return UserPrincipal.create(user);
	}
	
	@Transactional
	public UserDetails loadUserById(long id) {
		User user = userRepository.findById(id);
		
		return UserPrincipal.create(user);
	}
	
}
