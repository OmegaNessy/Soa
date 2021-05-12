package by.bntu.surveyofapplicants.soa.repository;

import by.bntu.surveyofapplicants.soa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByIdIn(List<Long> ids);
}
