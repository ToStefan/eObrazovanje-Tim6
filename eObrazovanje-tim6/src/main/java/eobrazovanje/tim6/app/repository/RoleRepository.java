package eobrazovanje.tim6.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.Role;
import eobrazovanje.tim6.app.entity.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(RoleName roleName);

}
