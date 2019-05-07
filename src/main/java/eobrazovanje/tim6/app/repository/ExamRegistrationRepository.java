package eobrazovanje.tim6.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.ExamRegistration;

@Repository
public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Long> {

}