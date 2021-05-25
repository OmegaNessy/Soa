package by.bntu.surveyofapplicants.soa.service.impl;

import by.bntu.surveyofapplicants.soa.dto.AnswerDto;
import by.bntu.surveyofapplicants.soa.entity.Answer;
import by.bntu.surveyofapplicants.soa.mapper.AnswerMapper;
import by.bntu.surveyofapplicants.soa.repository.AnswerRepository;
import by.bntu.surveyofapplicants.soa.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    AnswerMapper mapper;

    @Override
    public List<AnswerDto> getAllAnswersByQuestionId(Long id){
        List<AnswerDto> answersListDto = new ArrayList<>();
        List<Answer> answersList = answerRepository.findAllByQuestion_Id(id);
        for (Answer answer : answersList) {

            answersListDto.add(mapper.toDto(answer));
        }
        return answersListDto;
    }

    @Override
    public void saveAnswer(AnswerDto dto) {
        Answer answer = mapper.toEntity(dto);
        answerRepository.save(answer);
    }

    @Override
    public void deleteById(Long id){
        answerRepository.deleteById(id);
    }

    @Override
    public AnswerDto getAnswerById(Long id){
        return mapper.toDto(answerRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
