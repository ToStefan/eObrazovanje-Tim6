package eobrazovanje.tim6.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import eobrazovanje.tim6.app.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
