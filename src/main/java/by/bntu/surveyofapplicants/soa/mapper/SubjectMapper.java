package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.QuestionTypeDto;
import by.bntu.surveyofapplicants.soa.dto.SubjectDto;
import by.bntu.surveyofapplicants.soa.entity.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {
    @Autowired
    ModelMapper mapper;

    public SubjectDto toDto (Subject entity){
        return mapper.map(entity, SubjectDto.class);
    }
    public Subject toEntity (QuestionTypeDto dto){
        return mapper.map(dto, Subject.class);
    }
}
