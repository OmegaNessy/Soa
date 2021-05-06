package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.service.StudentService;
import by.bntu.surveyofapplicants.soa.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    TestService testService;
    @Autowired
    StudentService studentService;

    @GetMapping("/results")
    public String getResults(Model model){
        List<TestResult> results = testService.getAllResults();
        model.addAttribute("results",results);
        model.addAttribute("tests",testService.getAllTestsOfResults(results));
        model.addAttribute("students",studentService.getAllStudentsOfResults(results));
        return "resultList";
    }
}
