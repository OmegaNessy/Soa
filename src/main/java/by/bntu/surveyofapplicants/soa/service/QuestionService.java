package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    void deleteById(Long id);
    List<QuestionDto> getAllQuestionsByTestId(Long id);
    QuestionDto getQuestionById(Long id);
    void saveQuestion(QuestionDto dto);
}
