package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.QuestionDto;
import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.Question;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.mapper.QuestionMapper;
import by.bntu.surveyofapplicants.soa.mapper.TestMapper;
import by.bntu.surveyofapplicants.soa.repository.QuestionRepository;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionMapper mapper;

    @Autowired
    QuestionRepository questionRepository;

    public void saveQuestion(QuestionDto dto){
        Question question = mapper.toEntity(dto);
        questionRepository.save(question);
        System.out.println("smth");
    }

    public List<QuestionDto> getAllQuestionsByTestId(Long id){
        List<QuestionDto> questionsListDto = new ArrayList<>();
        List<Question> questionsList = questionRepository.findAllByTest_Id(id);
        for (Question question : questionsList) {
            questionsListDto.add(mapper.toDto(question));
        }
        return questionsListDto;
    }

    public void deleteById(Long id){
        questionRepository.deleteById(id);
    }

    public QuestionDto getQuestionById(Long id){
        return mapper.toDto(questionRepository.findById(id).orElseThrow(NullPointerException::new));
    }
//    public TestDto getTestById(Long id){
//        return mapper.toDto(testRepository.findById(id).orElseThrow(NullPointerException::new));
//    }
}
