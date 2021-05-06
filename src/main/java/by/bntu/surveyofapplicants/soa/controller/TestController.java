package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import by.bntu.surveyofapplicants.soa.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    static final String GENERAL_TEST_NAME = "Общий";

    @Autowired
    TestService service;

    @Autowired
    TestRepository repository;

    @GetMapping("/test/{id}")
    public Test testById(@PathVariable Long id){
        return repository.findTestByFacultyId(id);
    }

    @GetMapping("/test/general")
    public Test generalTest(){
        return repository.findTestByTestType(GENERAL_TEST_NAME);
    }

    @GetMapping("/test/all")
    public List<Test> getAllTests(){
        return repository.findAll();
    }

    @PostMapping("/test/result/add")
    public ResultDto addTestResult(@RequestBody MobileDto dto){
        return service.saveTestResult(dto);
    }
}
