package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.AnswerDto;
import by.bntu.surveyofapplicants.soa.entity.Answer;
import by.bntu.surveyofapplicants.soa.mapper.AnswerMapper;
import by.bntu.surveyofapplicants.soa.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    AnswerMapper mapper;

    public List<AnswerDto> getAllAnswersByQuestionId(Long id){
        List<AnswerDto> answersListDto = new ArrayList<>();
        List<Answer> answersList = answerRepository.findAllByQuestion_Id(id);
        for (Answer answer : answersList) {

            answersListDto.add(mapper.toDto(answer));
        }
        return answersListDto;
    }

    public void saveAnswer(AnswerDto dto) {
        Answer answer = mapper.toEntity(dto);
        answerRepository.save(answer);
    }

    public void deleteById(Long id){
        answerRepository.deleteById(id);
    }

    public AnswerDto getAnswerById(Long id){
        return mapper.toDto(answerRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
