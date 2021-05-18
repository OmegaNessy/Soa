package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultAttribute;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import by.bntu.surveyofapplicants.soa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TestResultMapper {
    @Autowired
    ModelMapper mapper;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;


    public TestResult toEntity(MobileDto dto, String result){
        return new TestResult(dto.getTestId(), Objects.nonNull(dto.getStudent())?dto.getStudent().getId():null,result);
    }

    public ResultDto toDto(TestResult entity){
        ResultAttribute resultAttribute = new ResultAttribute();
        if(null != facultyRepository.findByName(entity.getScore())){
            resultAttribute.setCode("facultyId");
            resultAttribute.setValue(facultyRepository.findByName(entity.getScore()).getId().toString());
            return new ResultDto(resultAttribute);
        }
        if(null != specialtyRepository.findByName(entity.getScore())){
            resultAttribute.setCode("specialtyId");
            resultAttribute.setValue(specialtyRepository.findByName(entity.getScore()).getId().toString());
            return new ResultDto(resultAttribute);
        }
        else{
            resultAttribute.setCode("otherAttribute");
            resultAttribute.setValue(entity.getScore());
            return new ResultDto(resultAttribute);
        }
    }
}
