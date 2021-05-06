package by.bntu.surveyofapplicants.soa.repository;

import by.bntu.surveyofapplicants.soa.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findAllByQuestion_Id(Long id);
    List<Answer> findAllByIdIn(Iterable<Long> idList);
}
