package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.AnswerDto;
import by.bntu.surveyofapplicants.soa.entity.Answer;
import by.bntu.surveyofapplicants.soa.entity.Question;
import by.bntu.surveyofapplicants.soa.repository.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AnswerMapper {
    @Autowired
    ModelMapper mapper;
    @Autowired
    QuestionRepository repository;

    public Answer toEntity(AnswerDto dto){
        return Objects.nonNull(dto) ? new Answer(dto.getId(),obtainQuestion(dto.getQuestionId()),dto.getScore(),dto.getAnswerText()):null;
    }

    public AnswerDto toDto(Answer answer){
        return Objects.nonNull(answer) ? new AnswerDto(answer.getId(),answer.getQuestion().getId(),
                answer.getAnswerText(),answer.getScore()):null;
    }

    private Question obtainQuestion(Long questionId) {
        Optional<Question> value = Objects.nonNull(questionId) ? repository.findById(questionId) : Optional.empty();
        Question question = new Question();
        if (value.isPresent()) {
            question = value.get();
        }
        return question;
    }
}
