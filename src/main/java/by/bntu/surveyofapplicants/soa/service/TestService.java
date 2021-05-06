package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.mapper.TestMapper;
import by.bntu.surveyofapplicants.soa.mapper.TestResultMapper;
import by.bntu.surveyofapplicants.soa.repository.AnswerRepository;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TestService {
    @Autowired
    TestMapper mapper;

    @Autowired
    TestResultMapper resultMapper;

    @Autowired
    TestRepository testRepository;
    @Autowired
    AnswerRepository answerRepository;

    public boolean saveTest(TestDto dto) {
        boolean flag = false;
        if (dto.getFacultyName().isEmpty() || Objects.isNull(dto.getFacultyName())) {
            dto.setFacultyName(null);
        }
        if(dto.getTestType().equals("Общий")) {
            if (Objects.isNull(testRepository.findTestByTestType("Общий"))) {
                testRepository.save(mapper.toEntity(dto));
                flag = true;
            }
        }
        else{
            testRepository.save(mapper.toEntity(dto));
            flag = true;
        }
        return flag;
    }

    public List<TestDto> getAllTests(){
        List<TestDto> testsListDto = new ArrayList<>();
        List<Test> testsList = testRepository.findAll();
        for (Test test:testsList) {
            testsListDto.add(mapper.toDto(test));
        }
        return testsListDto;
    }


    public TestDto getTestById(Long id){
        return mapper.toDto(testRepository.findById(id).orElseThrow(NullPointerException::new));
    }

//    public ResultDto saveTestResult(MobileDto dto){
//        String result = calculateResult(dto.getAnswers());
//        resultMapper.toEntity(dto);
//        return resultDto;
//    }
//
//    private String calculateResult(List<Long> answersIdList){
//        answerRepository.findAllByIdIn(answersIdList);
//        return result;
//    }
}
