package by.bntu.surveyofapplicants.soa.repository;

import by.bntu.surveyofapplicants.soa.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
    Test findTestByTestType(String type);
    Test findTestByFacultyId(Long id);
    List<Test> findByIdIn(List<Long> testIds);
}
