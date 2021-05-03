package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.mapper.TestMapper;
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
    TestRepository testRepository;

    public void saveTest(TestDto dto) {
        if (dto.getFacultyName().isEmpty() || Objects.isNull(dto.getFacultyName())) {
            dto.setFacultyName(null);
        }
        testRepository.save(mapper.toEntity(dto));
    }

    public void updateTest(TestDto dto){
        Test test = mapper.toEntity(dto);
        testRepository.save(test);
        System.out.println("TIME");
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
}
