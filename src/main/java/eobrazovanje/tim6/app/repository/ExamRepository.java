package eobrazovanje.tim6.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eobrazovanje.tim6.app.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
