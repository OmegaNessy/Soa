package by.bntu.surveyofapplicants.soa.service.impl;

import by.bntu.surveyofapplicants.soa.dto.QuestionTypeDto;
import by.bntu.surveyofapplicants.soa.entity.QuestionType;
import by.bntu.surveyofapplicants.soa.mapper.QuestionTypeMapper;
import by.bntu.surveyofapplicants.soa.repository.QuestionTypeRepository;
import by.bntu.surveyofapplicants.soa.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;
    @Autowired
    QuestionTypeMapper mapper;

    public List<QuestionTypeDto> getAllQuestionTypes(){
        List<QuestionType> questionTypeList = questionTypeRepository.findAll();
        List<QuestionTypeDto> questionTypeDtoList = new ArrayList<>();
        for(QuestionType questionType:questionTypeList){
            questionTypeDtoList.add(mapper.toDto(questionType));
        }
        return questionTypeDtoList;
    }
}
