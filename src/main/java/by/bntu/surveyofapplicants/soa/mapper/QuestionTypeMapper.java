package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.QuestionTypeDto;
import by.bntu.surveyofapplicants.soa.entity.QuestionType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionTypeMapper {
    @Autowired
    ModelMapper mapper;

    public QuestionTypeDto toDto (QuestionType entity){
        return mapper.map(entity,QuestionTypeDto.class);
    }

    public QuestionType toEntity (QuestionTypeDto dto){
        return mapper.map(dto,QuestionType.class);
    }
}
