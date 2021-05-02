package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.FacultyDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {
    @Autowired
    ModelMapper modelMapper;

    public FacultyDto toDto(Faculty entity){
        return modelMapper.map(entity,FacultyDto.class);
    }

    public Faculty toEntity(FacultyDto dto){
        return modelMapper.map(dto,Faculty.class);
    }
}
