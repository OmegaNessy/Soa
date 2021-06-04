package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultAttribute;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import by.bntu.surveyofapplicants.soa.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;
import java.util.Objects;

@Component
public class TestResultMapper {
    @Autowired
    ModelMapper mapper;
    @Autowired
    FacultyMapper facultyMapper;
    @Autowired
    SpecialtyMapper specialtyMapper;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;


    public TestResult toEntity(MobileDto dto, String result){
        GregorianCalendar gc = new GregorianCalendar();
        return new TestResult(dto.getTestId(), Objects.nonNull(dto.getStudent())?dto.getStudent().getId():null,result,gc.getTime());
    }

    public ResultDto toDto(TestResult entity){
        ResultDto resultDto = new ResultDto();
        if(null != facultyRepository.findByName(entity.getScore())){
            resultDto.setFaculty(facultyMapper.toDto(facultyRepository.findByName(entity.getScore())));
            return resultDto;
        }
        if(null != specialtyRepository.findByName(entity.getScore())){
            resultDto.setSpecialty(specialtyMapper.toDto(specialtyRepository.findByName(entity.getScore())));
        }
        else{
            resultDto.setOtherResult(entity.getScore());
        }
        return resultDto;
    }
}
