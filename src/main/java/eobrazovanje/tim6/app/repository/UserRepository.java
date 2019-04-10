package eobrazovanje.tim6.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eobrazovanje.tim6.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByIdIn(List<Long> userIds);

    User findByUsername(String username);
    
    User findById(long id);

    Boolean existsByUsername(String username);

	

}
