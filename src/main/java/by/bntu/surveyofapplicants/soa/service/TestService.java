package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.dto.TestApiDto;
import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.TestResult;

import java.util.List;
import java.util.Map;

public interface TestService {
    void deleteTest(Long id);
    List<TestApiDto> getAllApiTests();
    List<TestResult> getAllResults();
    List<TestDto> getAllTests();
    Map<Long,String> getAllTestsOfResults(List<TestResult> results);
    TestApiDto getGeneralTest(String value);
    TestApiDto getTestApiById(Long id);
    TestDto getTestById(Long id);
    boolean saveTest(TestDto dto);
    ResultDto saveTestResult(MobileDto dto);
}
