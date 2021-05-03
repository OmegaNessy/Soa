package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/test")
public class TestController {
    static final String GENERAL_TEST_NAME = "Общий";

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
}
