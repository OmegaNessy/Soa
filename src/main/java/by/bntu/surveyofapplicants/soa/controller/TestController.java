package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.dto.TestApiDto;
import by.bntu.surveyofapplicants.soa.service.TestService;
import by.bntu.surveyofapplicants.soa.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    static final String GENERAL_TEST_NAME = "Тест на определение факультета";

    @Autowired
    TestService service;

    @GetMapping("/test/{id}")
    public TestApiDto testById(@PathVariable Long id){
        return service.getTestApiById(id);
    }

    @GetMapping("/test/general")
    public TestApiDto generalTest(){
        return service.getGeneralTest(GENERAL_TEST_NAME);
    }

    @GetMapping("/test/all")
    public List<TestApiDto> getAllTests(){
        List<TestApiDto> list = service.getAllApiTests();
        return list;
    }

    @PostMapping("/test/result/add")
    public ResultDto addTestResult(@RequestBody MobileDto dto){
        return service.saveTestResult(dto);
    }
}
