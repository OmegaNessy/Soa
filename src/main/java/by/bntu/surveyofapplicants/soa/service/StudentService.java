package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.entity.Student;
import by.bntu.surveyofapplicants.soa.entity.TestResult;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Map<Long, Student> getAllStudentsOfResults(List<TestResult> results);
    Student saveStudent(Student student);
}
