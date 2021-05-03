package by.bntu.surveyofapplicants.soa.repository;

import by.bntu.surveyofapplicants.soa.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Long> {
    QuestionType findByValue(String value);
}
