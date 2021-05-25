package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    void deleteById(Long id);
    List<AnswerDto> getAllAnswersByQuestionId(Long id);
    AnswerDto getAnswerById(Long id);
    void saveAnswer(AnswerDto dto);
}
