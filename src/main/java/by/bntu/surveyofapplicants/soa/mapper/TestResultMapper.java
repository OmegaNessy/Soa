package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TestResultMapper {
    @Autowired
    ModelMapper mapper;
    @Autowired
    StudentRepository studentRepository;

    public TestResult toEntity(MobileDto dto, String result){
        return new TestResult(dto.getTestId(), Objects.nonNull(dto.getStudent())?dto.getStudent().getId():null,result);
    }

    public ResultDto toDto(TestResult entity){
        return mapper.map(entity,ResultDto.class);
    }

}
