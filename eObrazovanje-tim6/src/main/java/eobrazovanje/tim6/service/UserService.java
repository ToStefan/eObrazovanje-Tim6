package eobrazovanje.tim6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eobrazovanje.tim6.app.entity.User;
import eobrazovanje.tim6.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	List<User> users = new ArrayList<>();
	
	public List<User> getAllUsers() {
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}
	
}
